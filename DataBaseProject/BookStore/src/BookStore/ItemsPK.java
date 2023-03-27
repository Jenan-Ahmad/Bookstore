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
import javax.persistence.Embeddable;

/**
 *
 * @author Jenan
 */
@Embeddable
public class ItemsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "C_ID")
    private BigInteger cId;
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;

    public ItemsPK() {
    }

    public ItemsPK(BigInteger cId, String isbn) {
        this.cId = cId;
        this.isbn = isbn;
    }

    public BigInteger getCId() {
        return cId;
    }

    public void setCId(BigInteger cId) {
        this.cId = cId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cId != null ? cId.hashCode() : 0);
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsPK)) {
            return false;
        }
        ItemsPK other = (ItemsPK) object;
        if ((this.cId == null && other.cId != null) || (this.cId != null && !this.cId.equals(other.cId))) {
            return false;
        }
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.ItemsPK[ cId=" + cId + ", isbn=" + isbn + " ]";
    }
    
}
