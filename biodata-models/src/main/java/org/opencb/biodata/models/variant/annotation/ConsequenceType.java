package org.opencb.biodata.models.variant.annotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fjlopez on 19/11/14.
 */
public class ConsequenceType {

    private String geneName;
    private String ensemblGeneId;
    private String ensemblTranscriptId;
    private String strand;
    private String biotype;
    private Integer cDnaPosition;
    private Integer cdsPosition;
    private Integer aaPosition;
    private String aaChange;
    private String codon;
    private List<Score> proteinSubstitutionScores = null;
    private List<ConsequenceTypeEntry> soTerms;

    private Integer relativePosition;

    public ConsequenceType() { }

    public ConsequenceType(String soName) {
        this(Collections.singletonList(soName));
    }

    public ConsequenceType(List<String> soNameList) {
        this.soTerms = new ArrayList<>(soNameList.size());
        for(String soName : soNameList) {
            this.soTerms.add(new ConsequenceTypeEntry(soName));
        }
    }

    public ConsequenceType(String geneName, String ensemblGeneId, String ensemblTranscriptId, String strand,
                           String biotype, List<String> soNameList) {
        this(geneName, ensemblGeneId, ensemblTranscriptId, strand, biotype, null, soNameList);
    }

    public ConsequenceType(String geneName, String ensemblGeneId, String ensemblTranscriptId, String strand,
                           String biotype, Integer cDnaPosition, List<String> soNameList) {
        this(geneName, ensemblGeneId, ensemblTranscriptId, strand, biotype, cDnaPosition, null, null, null, null, null, soNameList);
    }

    public ConsequenceType(String geneName, String ensemblGeneId, String ensemblTranscriptId, String strand,
                           String biotype, Integer cDnaPosition, Integer cdsPosition, Integer aaPosition,
                           String aaChange, String codon, List<Score> proteinSubstitutionScores, List<String> soNameList) {
        this.geneName = geneName;
        this.ensemblGeneId = ensemblGeneId;
        this.ensemblTranscriptId = ensemblTranscriptId;
        this.strand = strand;
        this.soTerms = new ArrayList<>(soNameList.size());
        for(String soName : soNameList) {
            this.soTerms.add(new ConsequenceTypeEntry(soName));
        }
        this.biotype = biotype;
        this.cDnaPosition = cDnaPosition;
        this.cdsPosition = cdsPosition;
        this.aaPosition = aaPosition;
        this.aaChange = aaChange;
        this.codon = codon;
        this.proteinSubstitutionScores = proteinSubstitutionScores;
    }



    public void setEnsemblTranscriptId(String ensemblTranscriptId) {
        this.ensemblTranscriptId = ensemblTranscriptId;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public void setEnsemblGeneId(String ensemblGeneId) {
        this.ensemblGeneId = ensemblGeneId;
    }

    public void setRelativePosition(Integer relativePosition) {
        this.relativePosition = relativePosition;
    }

    public void setCodon(String codon) { this.codon = codon; }

    public void setStrand(String strand) { this.strand = strand; }

    public void setBiotype(String biotype) { this.biotype = biotype; }

    public void setcDnaPosition(Integer cDnaPosition) { this.cDnaPosition = cDnaPosition; }

    public void setCdsPosition(Integer cdsPosition) { this.cdsPosition = cdsPosition; }

    public void setAaPosition(Integer aaPosition) { this.aaPosition = aaPosition; }

    public void setAaChange(String aaChange) { this.aaChange = aaChange; }

    public void setProteinSubstitutionScores(List<Score> proteinSubstitutionScores) { this.proteinSubstitutionScores = proteinSubstitutionScores;  }

    public void addProteinSubstitutionScore(Score score) {
        if(this.proteinSubstitutionScores==null) {
            proteinSubstitutionScores = new ArrayList<>();
        }
        proteinSubstitutionScores.add(score);
    }

    public String getGeneName() {
        return geneName;
    }

    public String getEnsemblGeneId() {
        return ensemblGeneId;
    }

    public String getEnsemblGeneId(String defaultString) {
        if(ensemblGeneId!=null) {
            return ensemblGeneId;
        } else {
            return defaultString;
        }
    }

    public String getEnsemblTranscriptId() {
        return ensemblTranscriptId;
    }

    public Integer getRelativePosition() {
        return relativePosition;
    }

    public String getCodon() { return codon; }

    public String getCodon(String defaultString) {
        if(codon!=null) {
            return codon;
        } else {
            return defaultString;
        }
    }

    public String getStrand() { return strand; }

    public String getStrand(String defaultString) {
        if(strand!=null) {
            return strand;
        } else {
            return defaultString;
        }
    }

    public String getBiotype() { return biotype; }

    public String getBiotype(String defaultString) {
        if(biotype!=null) {
            return biotype;
        } else {
            return defaultString;
        }
    }

    public Integer getcDnaPosition() { return cDnaPosition; }

    public Integer getCdsPosition() { return cdsPosition; }

    public Integer getAaPosition() { return aaPosition; }

    public String getAaChange() { return aaChange; }

    public String getAaChange(String defaultString) {
        if(aaChange !=null) {
            return aaChange;
        } else {
            return defaultString;
        }
    }

    public List<Score> getProteinSubstitutionScores() {
        return proteinSubstitutionScores;
    }

    public List<ConsequenceTypeEntry> getSoTerms() {
        return soTerms;
    }

    public void setSoTerms(List<ConsequenceTypeEntry> soTerms) {
        this.soTerms = soTerms;
    }

    public void setSoTermsFromSoNames(List<String> soNameList) {
        this.soTerms = new ArrayList<>(soNameList.size());
        for(String soName : soNameList) {
            this.soTerms.add(new ConsequenceTypeEntry(soName));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsequenceType)) return false;

        ConsequenceType that = (ConsequenceType) o;

        if (aaChange != null ? !aaChange.equals(that.aaChange) : that.aaChange != null) return false;
        if (aaPosition != null ? !aaPosition.equals(that.aaPosition) : that.aaPosition != null) return false;
        if (biotype != null ? !biotype.equals(that.biotype) : that.biotype != null) return false;
        if (cDnaPosition != null ? !cDnaPosition.equals(that.cDnaPosition) : that.cDnaPosition != null) return false;
        if (cdsPosition != null ? !cdsPosition.equals(that.cdsPosition) : that.cdsPosition != null) return false;
        if (codon != null ? !codon.equals(that.codon) : that.codon != null) return false;
        if (ensemblGeneId != null ? !ensemblGeneId.equals(that.ensemblGeneId) : that.ensemblGeneId != null)
            return false;
        if (ensemblTranscriptId != null ? !ensemblTranscriptId.equals(that.ensemblTranscriptId) : that.ensemblTranscriptId != null)
            return false;
        if (geneName != null ? !geneName.equals(that.geneName) : that.geneName != null) return false;
        if (proteinSubstitutionScores != null ? !proteinSubstitutionScores.equals(that.proteinSubstitutionScores) : that.proteinSubstitutionScores != null)
            return false;
        if (relativePosition != null ? !relativePosition.equals(that.relativePosition) : that.relativePosition != null)
            return false;
        if (soTerms != null ? !soTerms.equals(that.soTerms) : that.soTerms != null) return false;
        if (strand != null ? !strand.equals(that.strand) : that.strand != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = geneName != null ? geneName.hashCode() : 0;
        result = 31 * result + (ensemblGeneId != null ? ensemblGeneId.hashCode() : 0);
        result = 31 * result + (ensemblTranscriptId != null ? ensemblTranscriptId.hashCode() : 0);
        result = 31 * result + (strand != null ? strand.hashCode() : 0);
        result = 31 * result + (biotype != null ? biotype.hashCode() : 0);
        result = 31 * result + (cDnaPosition != null ? cDnaPosition.hashCode() : 0);
        result = 31 * result + (cdsPosition != null ? cdsPosition.hashCode() : 0);
        result = 31 * result + (aaPosition != null ? aaPosition.hashCode() : 0);
        result = 31 * result + (aaChange != null ? aaChange.hashCode() : 0);
        result = 31 * result + (codon != null ? codon.hashCode() : 0);
        result = 31 * result + (proteinSubstitutionScores != null ? proteinSubstitutionScores.hashCode() : 0);
        result = 31 * result + (soTerms != null ? soTerms.hashCode() : 0);
        result = 31 * result + (relativePosition != null ? relativePosition.hashCode() : 0);
        return result;
    }

    static public class ConsequenceTypeEntry {
        private String soName;
        private String soAccession;

        public ConsequenceTypeEntry() {}

        public ConsequenceTypeEntry(String soName) {
            this(soName, ConsequenceTypeMappings.getSoAccessionString(soName));
        }

        public ConsequenceTypeEntry(String soName, String soAccession) {
            this.soName = soName;
            this.soAccession = soAccession;
        }

        public String getSoName() {
            return soName;
        }

        public void setSoName(String soName) {
            this.soName = soName;
        }

        public String getSoAccession() {
            return soAccession;
        }

        public void setSoAccession(String soAccession) {
            this.soAccession = soAccession;
        }
    }
}
