package org.opencb.biodata.models.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by antonior on 10/15/14.
 */
public class DisGeNet {

    /***
     geneID from ensembl
     ***/
    private String gene_ensemblID;

    /***
     gene HUGO symbol
     ***/
    private String geneName;

    /***
     gene name
     ***/
    private String geneSymbol;

    /***
     Disease
     ***/
    private List<Disease> diseases;

    public DisGeNet(String gene_ensemblID, String geneName, String geneSymbol, List<Disease> diseases) {
        this.gene_ensemblID = gene_ensemblID;
        this.geneName = geneName;
        this.geneSymbol = geneSymbol;
        this.diseases = diseases;
    }

    public String getGene_ensemblID() {
        return gene_ensemblID;
    }

    public void setGene_ensemblID(String gene_ensemblID) {
        this.gene_ensemblID = gene_ensemblID;
    }

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public String getGeneSymbol() {
        return geneSymbol;
    }

    public void setGeneSymbol(String geneSymbol) {
        this.geneSymbol = geneSymbol;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }


    public static class Disease {

        /***
         diseaseId
         ***/
        private String diseaseId;

        /***
         diseaseName
         ***/
        private String diseaseName;

        /***
         score value
         ***/
        private Float score;

        /***
         Number Of articles in Pubmeds
         ***/
        private Integer numberOfPubmeds;

        /***
         associationTypes
         ***/
        private List <String> associationTypes;

        /***
         Sources
         ***/
        private Set<String> sources;


        public Disease(String diseaseId, String diseaseName, Float score, Integer numberOfPubmeds, String associationTypes, Set<String> sources) {
            this.diseaseId = diseaseId;
            this.diseaseName = diseaseName;
            this.score = score;
            this.numberOfPubmeds = numberOfPubmeds;
            this.associationTypes = new ArrayList<>();
            this.associationTypes.add(associationTypes);
            this.sources = sources;
        }

        public String getDiseaseId() {
            return diseaseId;
        }

        public void setDiseaseId(String diseaseId) {
            this.diseaseId = diseaseId;
        }

        public String getDiseaseName() {
            return diseaseName;
        }

        public void setDiseaseName(String diseaseName) {
            this.diseaseName = diseaseName;
        }

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }

        public Integer getNumberOfPubmeds() {
            return numberOfPubmeds;
        }

        public void setNumberOfPubmeds(Integer numberOfPubmeds) {
            this.numberOfPubmeds = numberOfPubmeds;
        }

        public List<String> getAssociationTypes() {
            return associationTypes;
        }

        public void setAssociationTypes(List<String> associationTypes) {
            this.associationTypes = associationTypes;
        }

        public Set<String> getSources() {
            return sources;
        }

        public void setSources(Set<String> sources) {
            sources = sources;
        }
    }


}