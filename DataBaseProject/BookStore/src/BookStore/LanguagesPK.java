/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jenan
 */
@Embeddable
public class LanguagesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SSN")
    private String ssn;
    @Basic(optional = false)
    @Column(name = "LANGUAGESP")
    private String languagesp;

    public LanguagesPK() {
    }

    public LanguagesPK(String ssn, String languagesp) {
        this.ssn = ssn;
        this.languagesp = languagesp;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLanguagesp() {
        return languagesp;
    }

    public void setLanguagesp(String languagesp) {
        this.languagesp = languagesp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        hash += (languagesp != null ? languagesp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LanguagesPK)) {
            return false;
        }
        LanguagesPK other = (LanguagesPK) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        if ((this.languagesp == null && other.languagesp != null) || (this.languagesp != null && !this.languagesp.equals(other.languagesp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.LanguagesPK[ ssn=" + ssn + ", languagesp=" + languagesp + " ]";
    }
    
}
