/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "ITEMS_CUS")
@NamedQueries({
    @NamedQuery(name = "ItemsCus.findAll", query = "SELECT i FROM ItemsCus i"),
    @NamedQuery(name = "ItemsCus.findBySsn", query = "SELECT i FROM ItemsCus i WHERE i.ssn = :ssn"),
    @NamedQuery(name = "ItemsCus.findByIsbn", query = "SELECT i FROM ItemsCus i WHERE i.isbn = :isbn"),
    @NamedQuery(name = "ItemsCus.findByTitle", query = "SELECT i FROM ItemsCus i WHERE i.title = :title"),
    @NamedQuery(name = "ItemsCus.findByQuantity", query = "SELECT i FROM ItemsCus i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "ItemsCus.findByPrice", query = "SELECT i FROM ItemsCus i WHERE i.price = :price"),
    @NamedQuery(name = "ItemsCus.findByNumbr", query = "SELECT i FROM ItemsCus i WHERE i.numbr = :numbr")})
public class ItemsCus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "SSN")
    private String ssn;
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private String quantity;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private String price;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NUMBR")
    private BigDecimal numbr;

    public ItemsCus() {
    }

    public ItemsCus(BigDecimal numbr) {
        this.numbr = numbr;
    }

    public ItemsCus(BigDecimal numbr, String ssn, String isbn, String title, String quantity, String price) {
        this.numbr = numbr;
        this.ssn = ssn;
        this.isbn = isbn;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public BigDecimal getNumbr() {
        return numbr;
    }

    public void setNumbr(BigDecimal numbr) {
        this.numbr = numbr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numbr != null ? numbr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsCus)) {
            return false;
        }
        ItemsCus other = (ItemsCus) object;
        if ((this.numbr == null && other.numbr != null) || (this.numbr != null && !this.numbr.equals(other.numbr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.ItemsCus[ numbr=" + numbr + " ]";
    }
    
}
