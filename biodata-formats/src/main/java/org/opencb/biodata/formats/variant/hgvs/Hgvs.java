package org.opencb.biodata.formats.variant.hgvs;

import net.sf.picard.reference.IndexedFastaSequenceFile;
import org.opencb.biodata.formats.feature.refseq.RefseqAccession;
import org.opencb.biodata.models.variant.Variant;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by parce on 5/26/14.
 */
public class Hgvs {

    private static final String ACCESSION = "accesion";
    private static final String TYPE = "type";
    private static final String START = "start";
    private static final String STOP = "stop";
    private static final String CHANGE = "change";

    public static final String HGVS = "HGVS";
    private static final String GENOMIC_HGVS_TYPE = "g";

    private String accession;
    private String type;
    private int start;
    private int stop;
    private String change;

    private String hgvsString;

    private static Pattern pattern;

    static {
        String regEx = "(?<"+ACCESSION+">N\\S+):(?<"+TYPE+">\\w+).((?<"+START+">\\d*)_?(?<"+STOP+">\\d*))(?<"+CHANGE+">.+)";
        pattern = Pattern.compile(regEx);
    }

    public Hgvs(String hgvs) {
        this.hgvsString = hgvs;

        // parse the hgvs string
        Matcher matcher = pattern.matcher(hgvs);
        matcher.find();

        this.accession = matcher.group(Hgvs.ACCESSION);
        this.type = matcher.group(Hgvs.TYPE);
        this.start = Integer.parseInt(matcher.group(Hgvs.START));
        String stopString = matcher.group(Hgvs.STOP);
        if (stopString != null && !"".equals(stopString)) {
            this.stop = Integer.parseInt(stopString);
        } else {
            stop = this.start;
        }
        this.change = matcher.group(Hgvs.CHANGE);
        //this.change = StringEscapeUtils.unescapeXml(matcher.group(Hgvs.CHANGE));
    }

    public Hgvs(String accession, String type, int start, int stop, String reference, String alternate) {
        this.accession = accession;
        this.type = type;
        this.start = start;
        this.stop = stop;
        this.change = getChange(reference, alternate);
        String hgvsLocation = getHgvsLocation(start, stop);
        this.hgvsString = accession + ":" + type + "." + hgvsLocation  + this.change;
    }

    private String getHgvsLocation(int start, int stop) {
        if (start == stop) {
            return Integer.toString(start);
        } else {
            return start + "_" + stop;
        }
    }

    private String getChange(String reference, String alternate) {
        String change;

        if (reference.length() < alternate.length()) {
            if (alternate.equals(reference.concat(reference))) {
                change = "dup".concat(reference);
            } else {
                // TODO: could be an ins next to a del
                change = "ins".concat(alternate.replaceFirst(reference, ""));
            }
        } else if (reference.length() > alternate.length()) {
            // TODO: could be an ins next to a del
            change = "del".concat(reference.replaceFirst(alternate, ""));
        } else if (reference.equals("-")) {
            // TODO: use StringBuilder instead?
            change = "ins".concat(alternate);
        } else if (alternate.equals("-")) {
            // TODO: use StringBuilder instead?
            change = "del".concat(reference);
        } else {
            change = reference + ">" + alternate;
        }

        return change;
    }

    public Variant getVariant() throws ParseException {
        return getVariant(null);
    }

    public Variant getVariant(IndexedFastaSequenceFile genomeSequenceFastaFile) throws ParseException {

        Variant variant = null;
        // check that the HGVS is genomic
        if (type.equals(GENOMIC_HGVS_TYPE)) {
            // chr, start and stop
            String chromosome = getChromosome();

            // process change to obtain reference, alternative and shift start if needed
            if (change.contains(">")) {
                variant = getVariantFromSNV(chromosome);
            } else if (change.contains("del") && change.contains("ins")) {
                variant = getVariantFromComplexRearrangement(chromosome, genomeSequenceFastaFile);
            } else if (change.contains("dup")){
                variant = getVariantFromDuplication(chromosome, genomeSequenceFastaFile);
            } else if (change.contains("del")) {
                variant = getVariantFromDeletion(chromosome, genomeSequenceFastaFile);
            } else if (change.contains("ins")) {
                variant = getVariantFromInsertion(chromosome);
            } else {
                variant = null;
            }
        }

        return variant;
    }

    private String getChromosome() {
        if (RefseqAccession.isValidAccession(accession)) {
            return new RefseqAccession(accession).getChromosome();
        } else {
            return accession;
        }
    }

    private Variant getVariantFromComplexRearrangement(String chromosome, IndexedFastaSequenceFile genomeSequenceFastaFile) {
        // TODO: implement parser for changes like "NC_000016.10:g.2088677_2088679delTGAins5"
        return null;
    }

    private Variant getVariantFromSNV(String chromosome) {
        String[] changeNucleotides = change.split(">");
        return new Variant(chromosome, start, stop, changeNucleotides[0], changeNucleotides[1]);
    }

    private Variant getVariantFromInsertion(String chromosome) throws ParseException {
        Variant variant;
        try {
            String insertion = change.split("(ins)")[1];
            String referenceString = "-";
            variant = new Variant(chromosome, start, stop, referenceString, insertion);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParseException("Hgvs insertion malformed: " + change, change.length());
        }

        return variant;
    }

    private Variant getVariantFromDuplication(String chromosome, IndexedFastaSequenceFile genomeSequenceFastaFile) {
        String duplicatedNucleotides;
        String[] fields = change.split("(dup)");
        if (fields.length == 2) {
            // example g.187120195dupA or g.307_308dupTG
            duplicatedNucleotides = fields[1];
        } else {
            // example g.413dup or g.307_308dup
            if (genomeSequenceFastaFile != null) {
                duplicatedNucleotides = new String(genomeSequenceFastaFile.getSubsequenceAt(chromosome, start, stop).getBases());
            } else {
                // in this case, without genome sequence fasta file, duplicated nucleotides cannot be obtained
                duplicatedNucleotides = null;
            }
        }

        Variant variant = null;
        if (duplicatedNucleotides != null) {
            String referenceString = "-";
            variant = new Variant(chromosome, start, stop, referenceString, duplicatedNucleotides);
        }

        return variant;
    }

    private Variant getVariantFromDeletion(String chromosome, IndexedFastaSequenceFile genomeSequenceFastaFile) throws ParseException {
        String deletedNucleotides;
        String[] fields = change.split("(del)");
        if (fields.length == 2) {
            deletedNucleotides = fields[1];
        } else if (fields.length > 2) {
            throw new ParseException("Hgvs deletion malformed: " + change, change.lastIndexOf("del"));
        } else {
            if (genomeSequenceFastaFile != null) {
                deletedNucleotides = new String(genomeSequenceFastaFile.getSubsequenceAt(chromosome, start, stop).getBases());
            } else {
                // in this case, without genome sequence fasta file, deleted nucleotides cannot be obtained
                deletedNucleotides = null;
            }
        }

        Variant variant = null;
        if (deletedNucleotides != null) {
            String alternateString = "-";
            variant = new Variant(chromosome, start, stop, deletedNucleotides, alternateString);
        }

        return variant;
    }

    public String getAssembly() {
        String assembly = "";
        if (RefseqAccession.isValidAccession(accession)) {
            assembly = new RefseqAccession(accession).getAssembly();
        }
        return assembly;
    }

    @Override
    public String toString() {
        return hgvsString;
    }
}
