package com.books.stock.exchange.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
 * Books class is considered as an entity bean so that spring creates an object
 * and manages all other things
 * 
 * @Table tells to create table with the name as Books
 * @Data represents using lombok library so that to generate
 *       getter,setters,etc..,
 */
@Entity
@Table(name = "Books")
//@Data
public class Books {
	/**
	 * @Id represents publicationId will be primary key in the database
	 * @GeneratedValue represents that id should be generated automatically
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String bookTitle;
	private String bookPublishedYear;
	private String bookGenre;

	@JsonIgnore
	@ManyToOne
	private Author author;
	
	@JsonIgnore
	@ManyToOne
	private Publication publication;

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(int bookId, String bookTitle, String bookPublishedYear, String bookGenre, Author author,
			Publication publication) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPublishedYear = bookPublishedYear;
		this.bookGenre = bookGenre;
		this.author = author;
		this.publication = publication;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPublishedYear() {
		return bookPublishedYear;
	}

	public void setBookPublishedYear(String bookPublishedYear) {
		this.bookPublishedYear = bookPublishedYear;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPublishedYear=" + bookPublishedYear
				+ ", bookGenre=" + bookGenre + ", author=" + author + ", publication=" + publication + "]";
	}
	

}
