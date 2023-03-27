/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "ALL_SSN")
@NamedQueries({
    @NamedQuery(name = "AllSsn.findAll", query = "SELECT a FROM AllSsn a"),
    @NamedQuery(name = "AllSsn.findBySsn", query = "SELECT a FROM AllSsn a WHERE a.ssn = :ssn")})
public class AllSsn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SSN")
    private String ssn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ssn")
    private Collection<Accounts> accountsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "allSsn")
    private Applicants applicants;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "allSsn")
    private Customers customers;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "allSsn")
    private Employees employees;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "allSsn")
    private Manager manager;

    public AllSsn() {
    }

    public AllSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    public Applicants getApplicants() {
        return applicants;
    }

    public void setApplicants(Applicants applicants) {
        this.applicants = applicants;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AllSsn)) {
            return false;
        }
        AllSsn other = (AllSsn) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.AllSsn[ ssn=" + ssn + " ]";
    }
    
}
