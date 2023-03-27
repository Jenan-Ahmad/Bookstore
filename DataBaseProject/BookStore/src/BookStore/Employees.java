/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "EMPLOYEES")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findBySsn", query = "SELECT e FROM Employees e WHERE e.ssn = :ssn"),
    @NamedQuery(name = "Employees.findByFName", query = "SELECT e FROM Employees e WHERE e.fName = :fName"),
    @NamedQuery(name = "Employees.findByMName", query = "SELECT e FROM Employees e WHERE e.mName = :mName"),
    @NamedQuery(name = "Employees.findByLName", query = "SELECT e FROM Employees e WHERE e.lName = :lName"),
    @NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employees.findByPhone", query = "SELECT e FROM Employees e WHERE e.phone = :phone"),
    @NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city"),
    @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email"),
    @NamedQuery(name = "Employees.findByGender", query = "SELECT e FROM Employees e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employees.findBySalary", query = "SELECT e FROM Employees e WHERE e.salary = :salary")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SSN")
    private String ssn;
    @Basic(optional = false)
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "M_NAME")
    private String mName;
    @Basic(optional = false)
    @Column(name = "L_NAME")
    private String lName;
    @Basic(optional = false)
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @Column(name = "SALARY")
    private BigInteger salary;
    @Lob
    @Column(name = "E_IMAGE")
    private Serializable eImage;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AllSsn allSsn;

    public Employees() {
    }

    public Employees(String ssn) {
        this.ssn = ssn;
    }

    public Employees(String ssn, String fName, String lName, Date birthDate, String phone, String city, String email, String gender, BigInteger salary) {
        this.ssn = ssn;
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.city = city;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public Serializable getEImage() {
        return eImage;
    }

    public void setEImage(Serializable eImage) {
        this.eImage = eImage;
    }

    public AllSsn getAllSsn() {
        return allSsn;
    }

    public void setAllSsn(AllSsn allSsn) {
        this.allSsn = allSsn;
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
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Employees[ ssn=" + ssn + " ]";
    }
    
}
