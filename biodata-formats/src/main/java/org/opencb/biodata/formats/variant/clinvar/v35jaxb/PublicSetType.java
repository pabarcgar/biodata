//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.25 at 09:56:24 AM BST 
//


package org.opencb.biodata.formats.variant.clinvar.v35jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PublicSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicSetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecordStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="current"/>
 *               &lt;enumeration value="replaced"/>
 *               &lt;enumeration value="removed"/>
 *               &lt;enumeration value="not current"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReplacedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Replaces" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}ReferenceClinVarAssertion" minOccurs="0"/>
 *         &lt;element ref="{}ClinVarAssertion" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}CVIdentifiers"/>
 *       &lt;attribute name="DateLastUpdated" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublicSetType", propOrder = {
    "recordStatus",
    "replacedBy",
    "replaces",
    "title",
    "referenceClinVarAssertion",
    "clinVarAssertion"
})
public class PublicSetType {

    @XmlElement(name = "RecordStatus", required = true, defaultValue = "current")
    protected String recordStatus;
    @XmlElement(name = "ReplacedBy")
    protected String replacedBy;
    @XmlElement(name = "Replaces")
    protected List<String> replaces;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "ReferenceClinVarAssertion")
    protected ReferenceAssertionType referenceClinVarAssertion;
    @XmlElement(name = "ClinVarAssertion", required = true)
    protected List<MeasureTraitType> clinVarAssertion;
    @XmlAttribute(name = "DateLastUpdated")
    @XmlSchemaType(name = "anySimpleType")
    protected String dateLastUpdated;
    @XmlAttribute(name = "ID")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;

    /**
     * Gets the value of the recordStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     * Sets the value of the recordStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordStatus(String value) {
        this.recordStatus = value;
    }

    /**
     * Gets the value of the replacedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplacedBy() {
        return replacedBy;
    }

    /**
     * Sets the value of the replacedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplacedBy(String value) {
        this.replacedBy = value;
    }

    /**
     * Gets the value of the replaces property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the replaces property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReplaces().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReplaces() {
        if (replaces == null) {
            replaces = new ArrayList<String>();
        }
        return this.replaces;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * 
     * 					This element is not required becuase the PublicSetType is also used for SCV Accessions which do not have an RCV
     * 				
     * 
     * @return
     *     possible object is
     *     {@link ReferenceAssertionType }
     *     
     */
    public ReferenceAssertionType getReferenceClinVarAssertion() {
        return referenceClinVarAssertion;
    }

    /**
     * Sets the value of the referenceClinVarAssertion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceAssertionType }
     *     
     */
    public void setReferenceClinVarAssertion(ReferenceAssertionType value) {
        this.referenceClinVarAssertion = value;
    }

    /**
     * Gets the value of the clinVarAssertion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clinVarAssertion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClinVarAssertion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeasureTraitType }
     * 
     * 
     */
    public List<MeasureTraitType> getClinVarAssertion() {
        if (clinVarAssertion == null) {
            clinVarAssertion = new ArrayList<MeasureTraitType>();
        }
        return this.clinVarAssertion;
    }

    /**
     * Gets the value of the dateLastUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    /**
     * Sets the value of the dateLastUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateLastUpdated(String value) {
        this.dateLastUpdated = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setID(BigInteger value) {
        this.id = value;
    }

}
