/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "SUGGESTIONS")
@NamedQueries({
    @NamedQuery(name = "Suggestions.findAll", query = "SELECT s FROM Suggestions s"),
    @NamedQuery(name = "Suggestions.findBySNo", query = "SELECT s FROM Suggestions s WHERE s.sNo = :sNo"),
    @NamedQuery(name = "Suggestions.findByIsbn", query = "SELECT s FROM Suggestions s WHERE s.isbn = :isbn"),
    @NamedQuery(name = "Suggestions.findByTitle", query = "SELECT s FROM Suggestions s WHERE s.title = :title"),
    @NamedQuery(name = "Suggestions.findByAuthor", query = "SELECT s FROM Suggestions s WHERE s.author = :author"),
    @NamedQuery(name = "Suggestions.findBySDate", query = "SELECT s FROM Suggestions s WHERE s.sDate = :sDate"),
    @NamedQuery(name = "Suggestions.findBySeen", query = "SELECT s FROM Suggestions s WHERE s.seen = :seen")})
public class Suggestions implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "S_NO")
    private BigDecimal sNo;
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "AUTHOR")
    private String author;
    @Basic(optional = false)
    @Column(name = "S_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sDate;
    @Column(name = "SEEN")
    private Character seen;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN")
    @ManyToOne(optional = false)
    private Customers ssn;

    public Suggestions() {
    }

    public Suggestions(BigDecimal sNo) {
        this.sNo = sNo;
    }

    public Suggestions(BigDecimal sNo, String isbn, String title, String author, Date sDate) {
        this.sNo = sNo;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.sDate = sDate;
    }

    public BigDecimal getSNo() {
        return sNo;
    }

    public void setSNo(BigDecimal sNo) {
        this.sNo = sNo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getSDate() {
        return sDate;
    }

    public void setSDate(Date sDate) {
        this.sDate = sDate;
    }

    public Character getSeen() {
        return seen;
    }

    public void setSeen(Character seen) {
        this.seen = seen;
    }

    public Customers getSsn() {
        return ssn;
    }

    public void setSsn(Customers ssn) {
        this.ssn = ssn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sNo != null ? sNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suggestions)) {
            return false;
        }
        Suggestions other = (Suggestions) object;
        if ((this.sNo == null && other.sNo != null) || (this.sNo != null && !this.sNo.equals(other.sNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Suggestions[ sNo=" + sNo + " ]";
    }
    
}
