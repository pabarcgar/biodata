//
// This path was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this path will be lost upon recompilation of the source schema.
// Generated on: 2011.09.14 at 07:50:17 PM CEST 
//


package org.opencb.biodata.formats.protein.uniprot.v140jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * Describes the source of the data using a database cross-reference (or a 'ref' attribute when the source cannot be found in a public data source, such as PubMed, and is cited only within the UniProtKB entry).
 * <p/>
 * <p>Java class for sourceType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="sourceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dbReference" type="{http://uniprot.org/uniprot}dbReferenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceType", propOrder = {
        "dbReference"
})
public class SourceType {

    protected DbReferenceType dbReference;
    @XmlAttribute
    protected BigInteger ref;

    /**
     * Gets the value of the dbReference property.
     *
     * @return possible object is
     *         {@link DbReferenceType }
     */
    public DbReferenceType getDbReference() {
        return dbReference;
    }

    /**
     * Sets the value of the dbReference property.
     *
     * @param value allowed object is
     *              {@link DbReferenceType }
     */
    public void setDbReference(DbReferenceType value) {
        this.dbReference = value;
    }

    /**
     * Gets the value of the ref property.
     *
     * @return possible object is
     *         {@link java.math.BigInteger }
     */
    public BigInteger getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     *
     * @param value allowed object is
     *              {@link java.math.BigInteger }
     */
    public void setRef(BigInteger value) {
        this.ref = value;
    }

}
