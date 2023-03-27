/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "APPLICANTS")
@NamedQueries({
    @NamedQuery(name = "Applicants.findAll", query = "SELECT a FROM Applicants a"),
    @NamedQuery(name = "Applicants.findBySsn", query = "SELECT a FROM Applicants a WHERE a.ssn = :ssn"),
    @NamedQuery(name = "Applicants.findByFName", query = "SELECT a FROM Applicants a WHERE a.fName = :fName"),
    @NamedQuery(name = "Applicants.findByMName", query = "SELECT a FROM Applicants a WHERE a.mName = :mName"),
    @NamedQuery(name = "Applicants.findByLName", query = "SELECT a FROM Applicants a WHERE a.lName = :lName"),
    @NamedQuery(name = "Applicants.findByBirthDate", query = "SELECT a FROM Applicants a WHERE a.birthDate = :birthDate"),
    @NamedQuery(name = "Applicants.findByPhone", query = "SELECT a FROM Applicants a WHERE a.phone = :phone"),
    @NamedQuery(name = "Applicants.findByCity", query = "SELECT a FROM Applicants a WHERE a.city = :city"),
    @NamedQuery(name = "Applicants.findByEmail", query = "SELECT a FROM Applicants a WHERE a.email = :email"),
    @NamedQuery(name = "Applicants.findByGender", query = "SELECT a FROM Applicants a WHERE a.gender = :gender"),
    @NamedQuery(name = "Applicants.findByAcademicLevel", query = "SELECT a FROM Applicants a WHERE a.academicLevel = :academicLevel"),
    @NamedQuery(name = "Applicants.findByWorkingHours", query = "SELECT a FROM Applicants a WHERE a.workingHours = :workingHours"),
    @NamedQuery(name = "Applicants.findBySeen", query = "SELECT a FROM Applicants a WHERE a.seen = :seen")})
public class Applicants implements Serializable {

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
    @Column(name = "ACADEMIC_LEVEL")
    private String academicLevel;
    @Column(name = "WORKING_HOURS")
    private String workingHours;
    @Column(name = "SEEN")
    private Character seen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicants")
    private Collection<WorkingDays> workingDaysCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicants")
    private Collection<Languages> languagesCollection;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AllSsn allSsn;

    public Applicants() {
    }

    public Applicants(String ssn) {
        this.ssn = ssn;
    }

    public Applicants(String ssn, String fName, String lName, Date birthDate, String phone, String city, String email, String gender) {
        this.ssn = ssn;
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.city = city;
        this.email = email;
        this.gender = gender;
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

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public Character getSeen() {
        return seen;
    }

    public void setSeen(Character seen) {
        this.seen = seen;
    }

    public Collection<WorkingDays> getWorkingDaysCollection() {
        return workingDaysCollection;
    }

    public void setWorkingDaysCollection(Collection<WorkingDays> workingDaysCollection) {
        this.workingDaysCollection = workingDaysCollection;
    }

    public Collection<Languages> getLanguagesCollection() {
        return languagesCollection;
    }

    public void setLanguagesCollection(Collection<Languages> languagesCollection) {
        this.languagesCollection = languagesCollection;
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
        if (!(object instanceof Applicants)) {
            return false;
        }
        Applicants other = (Applicants) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Applicants[ ssn=" + ssn + " ]";
    }
    
}
