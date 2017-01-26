//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.26 at 11:28:51 AM GMT 
//


package org.opencb.biodata.formats.variant.clinvar.v37jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssertionTypeAttr.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AssertionTypeAttr">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="variation to disease"/>
 *     &lt;enumeration value="variation in modifier gene to disease"/>
 *     &lt;enumeration value="confers sensitivity"/>
 *     &lt;enumeration value="confers resistance"/>
 *     &lt;enumeration value="variant to named protein"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AssertionTypeAttr")
@XmlEnum
public enum AssertionTypeAttr {

    @XmlEnumValue("variation to disease")
    VARIATION_TO_DISEASE("variation to disease"),
    @XmlEnumValue("variation in modifier gene to disease")
    VARIATION_IN_MODIFIER_GENE_TO_DISEASE("variation in modifier gene to disease"),
    @XmlEnumValue("confers sensitivity")
    CONFERS_SENSITIVITY("confers sensitivity"),
    @XmlEnumValue("confers resistance")
    CONFERS_RESISTANCE("confers resistance"),
    @XmlEnumValue("variant to named protein")
    VARIANT_TO_NAMED_PROTEIN("variant to named protein");
    private final String value;

    AssertionTypeAttr(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssertionTypeAttr fromValue(String v) {
        for (AssertionTypeAttr c: AssertionTypeAttr.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
