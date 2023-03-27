/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "ROLES")
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByRId", query = "SELECT r FROM Roles r WHERE r.rId = :rId"),
    @NamedQuery(name = "Roles.findByRName", query = "SELECT r FROM Roles r WHERE r.rName = :rName")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "R_ID")
    private BigDecimal rId;
    @Basic(optional = false)
    @Column(name = "R_NAME")
    private String rName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rId")
    private Collection<Accounts> accountsCollection;

    public Roles() {
    }

    public Roles(BigDecimal rId) {
        this.rId = rId;
    }

    public Roles(BigDecimal rId, String rName) {
        this.rId = rId;
        this.rName = rName;
    }

    public BigDecimal getRId() {
        return rId;
    }

    public void setRId(BigDecimal rId) {
        this.rId = rId;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Roles[ rId=" + rId + " ]";
    }
    
}
