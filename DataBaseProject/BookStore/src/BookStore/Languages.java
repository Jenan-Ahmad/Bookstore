/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
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
@Table(name = "LANGUAGES")
@NamedQueries({
    @NamedQuery(name = "Languages.findAll", query = "SELECT l FROM Languages l"),
    @NamedQuery(name = "Languages.findBySsn", query = "SELECT l FROM Languages l WHERE l.languagesPK.ssn = :ssn"),
    @NamedQuery(name = "Languages.findByLanguagesp", query = "SELECT l FROM Languages l WHERE l.languagesPK.languagesp = :languagesp")})
public class Languages implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LanguagesPK languagesPK;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Applicants applicants;

    public Languages() {
    }

    public Languages(LanguagesPK languagesPK) {
        this.languagesPK = languagesPK;
    }

    public Languages(String ssn, String languagesp) {
        this.languagesPK = new LanguagesPK(ssn, languagesp);
    }

    public LanguagesPK getLanguagesPK() {
        return languagesPK;
    }

    public void setLanguagesPK(LanguagesPK languagesPK) {
        this.languagesPK = languagesPK;
    }

    public Applicants getApplicants() {
        return applicants;
    }

    public void setApplicants(Applicants applicants) {
        this.applicants = applicants;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languagesPK != null ? languagesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languages)) {
            return false;
        }
        Languages other = (Languages) object;
        if ((this.languagesPK == null && other.languagesPK != null) || (this.languagesPK != null && !this.languagesPK.equals(other.languagesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Languages[ languagesPK=" + languagesPK + " ]";
    }
    
}
