package org.opencb.biodata.tools.feature.refseq

import org.opencb.biodata.formats.feature.refseq.RefseqAccession
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by parce on 5/29/14.
 */
class RefseqAccessionTest extends Specification {

    @Unroll
    def "Refseq NC accession #accession should be translated to chromosome #chr from assembly #assembly"() {
        expect:
        RefseqAccession refseq = new RefseqAccession(accession)
        chr == refseq.getChromosome()
        assembly == refseq.getAssembly()

        where:
        accession       || chr  | assembly
        "NC_000001.10"  || "1"  | RefseqAccession.ASSEMBLY_37
        "NC_000001.11"  || "1"  | RefseqAccession.ASSEMBLY_38
        "NC_000002.11"  || "2"  | RefseqAccession.ASSEMBLY_37
        "NC_000002.12"  || "2"  | RefseqAccession.ASSEMBLY_38
        "NC_000003.11"  || "3"  | RefseqAccession.ASSEMBLY_37
        "NC_000003.12"  || "3"  | RefseqAccession.ASSEMBLY_38
        "NC_000004.11"  || "4"  | RefseqAccession.ASSEMBLY_37
        "NC_000004.12"  || "4"  | RefseqAccession.ASSEMBLY_38
        "NC_000005.9"   || "5"  | RefseqAccession.ASSEMBLY_37
        "NC_000005.10"  || "5"  | RefseqAccession.ASSEMBLY_38
        "NC_000006.11"  || "6"  | RefseqAccession.ASSEMBLY_37
        "NC_000006.12"  || "6"  | RefseqAccession.ASSEMBLY_38
        "NC_000007.13"  || "7"  | RefseqAccession.ASSEMBLY_37
        "NC_000007.14"  || "7"  | RefseqAccession.ASSEMBLY_38
        "NC_000008.10"  || "8"  | RefseqAccession.ASSEMBLY_37
        "NC_000008.11"  || "8"  | RefseqAccession.ASSEMBLY_38
        "NC_000009.11"  || "9"  | RefseqAccession.ASSEMBLY_37
        "NC_000009.12"  || "9"  | RefseqAccession.ASSEMBLY_38
        "NC_000010.10"  || "10" | RefseqAccession.ASSEMBLY_37
        "NC_000010.11"  || "10" | RefseqAccession.ASSEMBLY_38
        "NC_000011.9"   || "11" | RefseqAccession.ASSEMBLY_37
        "NC_000011.10"  || "11" | RefseqAccession.ASSEMBLY_38
        "NC_000012.11"  || "12" | RefseqAccession.ASSEMBLY_37
        "NC_000012.12"  || "12" | RefseqAccession.ASSEMBLY_38
        "NC_000013.10"  || "13" | RefseqAccession.ASSEMBLY_37
        "NC_000013.11"  || "13" | RefseqAccession.ASSEMBLY_38
        "NC_000014.8"   || "14" | RefseqAccession.ASSEMBLY_37
        "NC_000014.9"   || "14" | RefseqAccession.ASSEMBLY_38
        "NC_000015.9"   || "15" | RefseqAccession.ASSEMBLY_37
        "NC_000015.10"  || "15" | RefseqAccession.ASSEMBLY_38
        "NC_000016.9"   || "16" | RefseqAccession.ASSEMBLY_37
        "NC_000016.10"  || "16" | RefseqAccession.ASSEMBLY_38
        "NC_000017.10"  || "17" | RefseqAccession.ASSEMBLY_37
        "NC_000017.11"  || "17" | RefseqAccession.ASSEMBLY_38
        "NC_000018.9"   || "18" | RefseqAccession.ASSEMBLY_37
        "NC_000018.10"  || "18" | RefseqAccession.ASSEMBLY_38
        "NC_000019.9"   || "19" | RefseqAccession.ASSEMBLY_37
        "NC_000019.10"  || "19" | RefseqAccession.ASSEMBLY_38
        "NC_000020.10"  || "20" | RefseqAccession.ASSEMBLY_37
        "NC_000020.11"  || "20" | RefseqAccession.ASSEMBLY_38
        "NC_000021.8"   || "21" | RefseqAccession.ASSEMBLY_37
        "NC_000021.9"   || "21" | RefseqAccession.ASSEMBLY_38
        "NC_000022.10"  || "22" | RefseqAccession.ASSEMBLY_37
        "NC_000022.11"  || "22" | RefseqAccession.ASSEMBLY_38
        "NC_000023.10"  || "X"  | RefseqAccession.ASSEMBLY_37
        "NC_000023.11"  || "X"  | RefseqAccession.ASSEMBLY_38
        "NC_000024.9"   || "Y"  | RefseqAccession.ASSEMBLY_37
        "NC_000024.10"  || "Y"  | RefseqAccession.ASSEMBLY_38
        "NC_012920.1"   || "MT" | ""
    }

    @Unroll
    def "refseq accession #accession is not a reference assembly complete genomic molecule and cannot be translated to chromosome"() {
        expect:
        new RefseqAccession(accession).getChromosome() == null

        where:
        accession << ["AC_89438953495", "NG_23889324", "NT_34993020", "NM_000020347823"]
    }

    @Ignore("Test used to choose one refseqNCAccessionToChromosome implementation")
    def "performance test of Refseq.refseqNCAccessionToChromosome implementations"() {
        given:
        def accessionList = ["NC_000001.10", "NC_000001.11", "NC_000002.11", "NC_000002.12", "NC_000003.11",
                             "NC_000003.12", "NC_000004.11", "NC_000004.12", "NC_000005.10", "NC_000005.9",
                             "NC_000006.11", "NC_000006.12", "NC_000007.13", "NC_000007.14", "NC_000008.10",
                             "NC_000008.11", "NC_000009.11", "NC_000009.12", "NC_000010.10", "NC_000010.11",
                             "NC_000011.10", "NC_000011.9", "NC_000012.11", "NC_000012.12", "NC_000013.10",
                             "NC_000013.11", "NC_000014.8", "NC_000014.9", "NC_000015.10", "NC_000015.9",
                             "NC_000016.10", "NC_000016.9", "NC_000017.10", "NC_000017.11", "NC_000018.10",
                             "NC_000018.9", "NC_000019.10", "NC_000019.9", "NC_000020.10", "NC_000020.11",
                             "NC_000021.8", "NC_000021.9", "NC_000022.10", "NC_000022.11", "NC_000023.10",
                             "NC_000023.11", "NC_000024.10", "NC_000024.9", "NC_012920.1"]
        def random = new Random()
        def iterations = 1000000

        // cached version
        def init = System.currentTimeMillis()
        (0..iterations).each {
            def i = random.nextInt(accessionList.size())
            new RefseqAccession(accessionList.get(i)).getChromosome()
        }
        def cachedVersionElapsedTime = System.currentTimeMillis() - init
        println "cached version elapsed time ${cachedVersionElapsedTime} ms."

        // uncached version
        init = System.currentTimeMillis()
        (0..iterations).each {
            def i = random.nextInt(accessionList.size())
            new RefseqAccession(accessionList.get(i)).uncachedRefseqNCAccessionToChromosome()
        }
        def uncachedVersionElapsedTime = System.currentTimeMillis() - init
        println "uncached version elapsed time ${uncachedVersionElapsedTime} ms."

        expect:
        uncachedVersionElapsedTime > cachedVersionElapsedTime
    }

    @Unroll
    def "#accession is a valid Refseq accession"() {
        expect:
        RefseqAccession.isValidAccession(accession)

        where:
        accession << ["NC_000001.10", "NC_000001.11", "NT_187361.1", "NW_011332688.1", "NP_858066.1", "NR_037072.1",
                      "YP_009074617.1", "XP_006464197.1", "AP_004912.1", "XR_369108.1", "XM_006464133.1", "NM_001288847.1",
                      "NZ_JRLT01000007.1", "NG_035090.1", "AC_000139.1", "NC_000015"]
    }

    @Unroll
    def "#accession is not a valid Refseq accession" () {
        expect:
        !RefseqAccession.isValidAccession(accession)

        where:
        accession << ["ENSG00000218839", "ENST00000473358", "ENSE00001667650", "2", "chr4", "NC_0000012.10", "NC_00002.10",
                      "NC_000002.1054", "NC_000002.","NZ_JRLT000007.1", "NZ_JRLT501000007.1", "NZ_JRLTAG000007.1"]
    }
}
