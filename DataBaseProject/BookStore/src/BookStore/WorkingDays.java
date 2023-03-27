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
@Table(name = "WORKING_DAYS")
@NamedQueries({
    @NamedQuery(name = "WorkingDays.findAll", query = "SELECT w FROM WorkingDays w"),
    @NamedQuery(name = "WorkingDays.findBySsn", query = "SELECT w FROM WorkingDays w WHERE w.workingDaysPK.ssn = :ssn"),
    @NamedQuery(name = "WorkingDays.findByWday", query = "SELECT w FROM WorkingDays w WHERE w.workingDaysPK.wday = :wday")})
public class WorkingDays implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorkingDaysPK workingDaysPK;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Applicants applicants;

    public WorkingDays() {
    }

    public WorkingDays(WorkingDaysPK workingDaysPK) {
        this.workingDaysPK = workingDaysPK;
    }

    public WorkingDays(String ssn, String wday) {
        this.workingDaysPK = new WorkingDaysPK(ssn, wday);
    }

    public WorkingDaysPK getWorkingDaysPK() {
        return workingDaysPK;
    }

    public void setWorkingDaysPK(WorkingDaysPK workingDaysPK) {
        this.workingDaysPK = workingDaysPK;
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
        hash += (workingDaysPK != null ? workingDaysPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingDays)) {
            return false;
        }
        WorkingDays other = (WorkingDays) object;
        if ((this.workingDaysPK == null && other.workingDaysPK != null) || (this.workingDaysPK != null && !this.workingDaysPK.equals(other.workingDaysPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.WorkingDays[ workingDaysPK=" + workingDaysPK + " ]";
    }
    
}
