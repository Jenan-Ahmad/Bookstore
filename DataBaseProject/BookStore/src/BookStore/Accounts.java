/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ACCOUNTS")
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByUsername", query = "SELECT a FROM Accounts a WHERE a.username = :username"),
    @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN")
    @ManyToOne(optional = false)
    private AllSsn ssn;
    @JoinColumn(name = "R_ID", referencedColumnName = "R_ID")
    @ManyToOne(optional = false)
    private Roles rId;

    public Accounts() {
    }

    public Accounts(String username) {
        this.username = username;
    }

    public Accounts(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AllSsn getSsn() {
        return ssn;
    }

    public void setSsn(AllSsn ssn) {
        this.ssn = ssn;
    }

    public Roles getRId() {
        return rId;
    }

    public void setRId(Roles rId) {
        this.rId = rId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Accounts[ username=" + username + " ]";
    }
    
}
