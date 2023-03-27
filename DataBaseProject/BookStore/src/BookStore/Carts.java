/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "CARTS")
@NamedQueries({
    @NamedQuery(name = "Carts.findAll", query = "SELECT c FROM Carts c"),
    @NamedQuery(name = "Carts.findBySsn", query = "SELECT c FROM Carts c WHERE c.ssn.ssn = :SSN"),
    @NamedQuery(name = "Carts.findByCId", query = "SELECT c FROM Carts c WHERE c.cId = :cId"),
    @NamedQuery(name = "Carts.findByCDate", query = "SELECT c FROM Carts c WHERE c.cDate = :cDate"),
    @NamedQuery(name = "Carts.findByTPrice", query = "SELECT c FROM Carts c WHERE c.tPrice = :tPrice")})
public class Carts implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "C_ID")
    private BigDecimal cId;
    @Basic(optional = false)
    @Column(name = "C_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cDate;
    @Basic(optional = false)
    @Column(name = "T_PRICE")
    private BigInteger tPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private Collection<Items> itemsCollection;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN")
    @ManyToOne(optional = false)
    private Customers ssn;

    public Carts() {
    }

    public Carts(BigDecimal cId) {
        this.cId = cId;
    }

    public Carts(BigDecimal cId, Date cDate, BigInteger tPrice) {
        this.cId = cId;
        this.cDate = cDate;
        this.tPrice = tPrice;
    }

    public BigDecimal getCId() {
        return cId;
    }

    public void setCId(BigDecimal cId) {
        this.cId = cId;
    }

    public Date getCDate() {
        return cDate;
    }

    public void setCDate(Date cDate) {
        this.cDate = cDate;
    }

    public BigInteger getTPrice() {
        return tPrice;
    }

    public void setTPrice(BigInteger tPrice) {
        this.tPrice = tPrice;
    }

    public Collection<Items> getItemsCollection() {
        return itemsCollection;
    }

    public void setItemsCollection(Collection<Items> itemsCollection) {
        this.itemsCollection = itemsCollection;
    }

    public Customers getSsn() {
        return ssn;
    }

    public void setSsn(Customers ssn) {
        this.ssn = ssn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carts)) {
            return false;
        }
        Carts other = (Carts) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Carts[ cId=" + cId + " ]";
    }
    
}
