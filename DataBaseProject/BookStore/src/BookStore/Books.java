/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jenan
 */
@Entity
@Table(name = "BOOKS")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findByIsbn", query = "SELECT b FROM Books b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Books.findByTitle", query = "SELECT b FROM Books b WHERE b.title = :title"),
    @NamedQuery(name = "Books.findByAuthor", query = "SELECT b FROM Books b WHERE b.author = :author"),
    @NamedQuery(name = "Books.findByBDescription", query = "SELECT b FROM Books b WHERE b.bDescription = :bDescription"),
    @NamedQuery(name = "Books.findByPrice", query = "SELECT b FROM Books b WHERE b.price = :price"),
    @NamedQuery(name = "Books.findByQuantity", query = "SELECT b FROM Books b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Books.findByBLanguage", query = "SELECT b FROM Books b WHERE b.bLanguage = :bLanguage")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Lob
    @Column(name = "BOOK_IMAGE")
    private Serializable bookImage;
    @Basic(optional = false)
    @Column(name = "AUTHOR")
    private String author;
    @Basic(optional = false)
    @Column(name = "B_DESCRIPTION")
    private String bDescription;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private BigInteger price;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Basic(optional = false)
    @Column(name = "B_LANGUAGE")
    private String bLanguage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private Collection<Items> itemsCollection;

    public Books() {
    }

    public Books(String isbn) {
        this.isbn = isbn;
    }

    public Books(String isbn, String title, String author, String bDescription, BigInteger price, BigInteger quantity, String bLanguage) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.bDescription = bDescription;
        this.price = price;
        this.quantity = quantity;
        this.bLanguage = bLanguage;
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

    public Serializable getBookImage() {
        return bookImage;
    }

    public void setBookImage(Serializable bookImage) {
        this.bookImage = bookImage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBDescription() {
        return bDescription;
    }

    public void setBDescription(String bDescription) {
        this.bDescription = bDescription;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getBLanguage() {
        return bLanguage;
    }

    public void setBLanguage(String bLanguage) {
        this.bLanguage = bLanguage;
    }

    public Collection<Items> getItemsCollection() {
        return itemsCollection;
    }

    public void setItemsCollection(Collection<Items> itemsCollection) {
        this.itemsCollection = itemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.Books[ isbn=" + isbn + " ]";
    }
    
}
