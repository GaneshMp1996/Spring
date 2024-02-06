package com.books.stock.exchange.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 
 * @author Pavithra Prakash
 *
 */
/**
 * 
 * Publication class is considered as an entity bean so that spring creates an
 * object and manages all other things
 * 
 * @Table tells to create table with the name as Publication
 * @Data represents using lombok library so that to generate
 *       getter,setters,etc..,
 */
@Entity
@Table(name = "Publication")
//@Data
public class Publication {
	/**
	 * @Id represents publicationId will be primary key in the database
	 * @GeneratedValue represents that id should be generated automatically
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int publicationId;
	private String publisherName;
	private String publishingDate;

	
	  @JsonIgnore
	  @ManyToMany(mappedBy = "publications") 
	  private List<Author> authors;
	  
	  @OneToMany(mappedBy = "publication")
	  private List<Books> books;

	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publication(int publicationId, String publisherName, String publishingDate, List<Author> authors,
			List<Books> books) {
		super();
		this.publicationId = publicationId;
		this.publisherName = publisherName;
		this.publishingDate = publishingDate;
		this.authors = authors;
		this.books = books;
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publication [publicationId=" + publicationId + ", publisherName=" + publisherName + ", publishingDate="
				+ publishingDate + ", authors=" + authors + ", books=" + books + "]";
	}
	 

}
