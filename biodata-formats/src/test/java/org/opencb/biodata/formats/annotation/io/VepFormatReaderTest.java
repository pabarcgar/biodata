package org.opencb.biodata.formats.annotation.io;

import org.junit.Test;
import org.opencb.biodata.models.variant.annotation.VariantAnnotation;

import java.util.List;

import static org.junit.Assert.*;

public class VepFormatReaderTest {

    @Test
    public void testRead() throws Exception {
//        VepFormatReader vepFormatReader = new VepFormatReader("/home/fjlopez/EBI/eva/data/clinvar.vep");
        VepFormatReader vepFormatReader = new VepFormatReader("/tmp/test.vep");
//        VepFormatReader vepFormatReader = new VepFormatReader("/tmp/vep22.vep");
//        VepFormatReader vepFormatReader = new VepFormatReader("/tmp/test.vep");
//        VepFormatReader vepFormatReader = new VepFormatReader("/tmp/vep22.head.tsv");
//        VepFormatReader vepFormatReader = new VepFormatReader("/tmp/test1.vep");
        vepFormatReader.open();
        vepFormatReader.pre();
        List<VariantAnnotation> variantAnnotationList = vepFormatReader.read(10000);
        vepFormatReader.post();
        vepFormatReader.close();
    }
}