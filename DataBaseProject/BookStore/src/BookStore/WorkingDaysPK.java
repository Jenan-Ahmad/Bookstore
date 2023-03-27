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
public class WorkingDaysPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SSN")
    private String ssn;
    @Basic(optional = false)
    @Column(name = "WDAY")
    private String wday;

    public WorkingDaysPK() {
    }

    public WorkingDaysPK(String ssn, String wday) {
        this.ssn = ssn;
        this.wday = wday;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getWday() {
        return wday;
    }

    public void setWday(String wday) {
        this.wday = wday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        hash += (wday != null ? wday.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingDaysPK)) {
            return false;
        }
        WorkingDaysPK other = (WorkingDaysPK) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        if ((this.wday == null && other.wday != null) || (this.wday != null && !this.wday.equals(other.wday))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.WorkingDaysPK[ ssn=" + ssn + ", wday=" + wday + " ]";
    }
    
}
