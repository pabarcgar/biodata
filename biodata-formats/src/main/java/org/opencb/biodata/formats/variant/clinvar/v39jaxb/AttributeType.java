//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.10 at 12:12:23 PM GMT 
//


package org.opencb.biodata.formats.variant.clinvar.v39jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * The attribute is a general element to represent a defined set of data
 * 				qualified by an enumerated set of types. For each attribute element, the value will
 * 				be a character string and is optional. Source shall be used to store identifiers for
 * 				supplied data from source other than the submitter (e.g. SequenceOntology). The data
 * 				submitted where Type="variation" shall be validated against sequence_alternation in
 * 				Sequence Ontology http://www.sequenceontology.org/. This is to be a generic version
 * 				of AttributeType and should be used with extension when it is used to specify Type
 * 				and its enumerations. 
 * 
 * <p>Java class for AttributeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttributeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="integerValue" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="dateValue" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeType", propOrder = {
    "value"
})
@XmlSeeAlso({
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.ReferenceAssertionType.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.MeasureTraitType.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.MeasureSetType.Measure.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.MeasureSetType.Measure.MeasureRelationship.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.MeasureSetType.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.ClinAsserTraitSetType.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.ClinAsserTraitType.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.ClinAsserTraitType.TraitRelationship.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.TraitType.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.TraitType.TraitRelationship.AttributeSet.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.MethodType.MethodAttribute.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.ObservationSet.ObservedData.Attribute.class,
    org.opencb.biodata.formats.variant.clinvar.v39jaxb.TraitSetType.AttributeSet.Attribute.class
})
public class AttributeType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "integerValue")
    protected Integer integerValue;
    @XmlAttribute(name = "dateValue")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateValue;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the integerValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntegerValue() {
        return integerValue;
    }

    /**
     * Sets the value of the integerValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntegerValue(Integer value) {
        this.integerValue = value;
    }

    /**
     * Gets the value of the dateValue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValue() {
        return dateValue;
    }

    /**
     * Sets the value of the dateValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValue(XMLGregorianCalendar value) {
        this.dateValue = value;
    }

}
