//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.19 at 09:23:06 AM BST 
//


package org.opencb.biodata.formats.variant.clinvar.v43jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Structure to describe attributes of any family data in an observation.
 * 				If the details of the number of families and the de-identified pedigree id are not available,
 * 				use FamilyHistory to describe what type of family data is available.  Can also be used to report 'Yes' or 'No' 
 * 				if there are no more details.
 * 			
 * 
 * <p>Java class for FamilyInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FamilyInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FamilyHistory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="NumFamilies" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="NumFamiliesWithVariant" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="NumFamiliesWithSegregationObserved" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PedigreeID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SegregationObserved" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FamilyInfo", propOrder = {
    "familyHistory"
})
public class FamilyInfo {

    @XmlElement(name = "FamilyHistory")
    protected String familyHistory;
    @XmlAttribute(name = "NumFamilies")
    protected Integer numFamilies;
    @XmlAttribute(name = "NumFamiliesWithVariant")
    protected Integer numFamiliesWithVariant;
    @XmlAttribute(name = "NumFamiliesWithSegregationObserved")
    protected Integer numFamiliesWithSegregationObserved;
    @XmlAttribute(name = "PedigreeID")
    protected String pedigreeID;
    @XmlAttribute(name = "SegregationObserved")
    protected String segregationObserved;

    /**
     * Gets the value of the familyHistory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyHistory() {
        return familyHistory;
    }

    /**
     * Sets the value of the familyHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyHistory(String value) {
        this.familyHistory = value;
    }

    /**
     * Gets the value of the numFamilies property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumFamilies() {
        return numFamilies;
    }

    /**
     * Sets the value of the numFamilies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumFamilies(Integer value) {
        this.numFamilies = value;
    }

    /**
     * Gets the value of the numFamiliesWithVariant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumFamiliesWithVariant() {
        return numFamiliesWithVariant;
    }

    /**
     * Sets the value of the numFamiliesWithVariant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumFamiliesWithVariant(Integer value) {
        this.numFamiliesWithVariant = value;
    }

    /**
     * Gets the value of the numFamiliesWithSegregationObserved property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumFamiliesWithSegregationObserved() {
        return numFamiliesWithSegregationObserved;
    }

    /**
     * Sets the value of the numFamiliesWithSegregationObserved property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumFamiliesWithSegregationObserved(Integer value) {
        this.numFamiliesWithSegregationObserved = value;
    }

    /**
     * Gets the value of the pedigreeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPedigreeID() {
        return pedigreeID;
    }

    /**
     * Sets the value of the pedigreeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPedigreeID(String value) {
        this.pedigreeID = value;
    }

    /**
     * Gets the value of the segregationObserved property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegregationObserved() {
        return segregationObserved;
    }

    /**
     * Sets the value of the segregationObserved property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegregationObserved(String value) {
        this.segregationObserved = value;
    }

}
