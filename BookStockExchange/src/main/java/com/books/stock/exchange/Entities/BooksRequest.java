package com.books.stock.exchange.Entities;

public class BooksRequest {
	
	public int id;
	public String bookTitle;
	public String bookPublishedYear;
	public String bookGenre;
	public int author_id;
	public int publication_id;
	public BooksRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BooksRequest(int id, String bookTitle, String bookPublishedYear, String bookGenre, int author_id,
			int publication_id) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookPublishedYear = bookPublishedYear;
		this.bookGenre = bookGenre;
		this.author_id = author_id;
		this.publication_id = publication_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getPublication_id() {
		return publication_id;
	}
	public void setPublication_id(int publication_id) {
		this.publication_id = publication_id;
	}
	@Override
	public String toString() {
		return "BooksRequest [id=" + id + ", bookTitle=" + bookTitle + ", bookPublishedYear=" + bookPublishedYear
				+ ", bookGenre=" + bookGenre + ", author_id=" + author_id + ", publication_id=" + publication_id + "]";
	}
	

}
