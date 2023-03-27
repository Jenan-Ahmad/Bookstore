/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "ITEMS")
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByCId", query = "SELECT i FROM Items i WHERE i.itemsPK.cId = :cId"),
    @NamedQuery(name = "Items.findByIsbn", query = "SELECT i FROM Items i WHERE i.itemsPK.isbn = :isbn"),
    @NamedQuery(name = "Items.findByQuantity", query = "SELECT i FROM Items i WHERE i.quantity = :quantity")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemsPK itemsPK;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carts carts;

    public Items() {
    }

    public Items(ItemsPK itemsPK) {
        this.itemsPK = itemsPK;
    }

    public Items(ItemsPK itemsPK, BigInteger quantity) {
        this.itemsPK = itemsPK;
        this.quantity = quantity;
    }

    public Items(BigInteger cId, String isbn) {
        this.itemsPK = new ItemsPK(cId, isbn);
    }

    public ItemsPK getItemsPK() {
        return itemsPK;
    }

    public void setItemsPK(ItemsPK itemsPK) {
        this.itemsPK = itemsPK;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Carts getCarts() {
        return carts;
    }

    public void setCarts(Carts carts) {
        this.carts = carts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemsPK != null ? itemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemsPK == null && other.itemsPK != null) || (this.itemsPK != null && !this.itemsPK.equals(other.itemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Items[ itemsPK=" + itemsPK + " ]";
    }
    
}
