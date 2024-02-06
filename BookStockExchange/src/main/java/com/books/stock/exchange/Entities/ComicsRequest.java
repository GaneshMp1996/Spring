package com.books.stock.exchange.Entities;

public class ComicsRequest {

	public int id;
	public String comicTitle;
	public String comicPublishedYear;
	public String comicHero; 
	public int author_id;
	public ComicsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComicsRequest(int id, String comicTitle, String comicPublishedYear, String comicHero, int author_id) {
		super();
		this.id = id;
		this.comicTitle = comicTitle;
		this.comicPublishedYear = comicPublishedYear;
		this.comicHero = comicHero;
		this.author_id = author_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComicTitle() {
		return comicTitle;
	}
	public void setComicTitle(String comicTitle) {
		this.comicTitle = comicTitle;
	}
	public String getComicPublishedYear() {
		return comicPublishedYear;
	}
	public void setComicPublishedYear(String comicPublishedYear) {
		this.comicPublishedYear = comicPublishedYear;
	}
	public String getComicHero() {
		return comicHero;
	}
	public void setComicHero(String comicHero) {
		this.comicHero = comicHero;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	@Override
	public String toString() {
		return "ComicsRequest [id=" + id + ", comicTitle=" + comicTitle + ", comicPublishedYear=" + comicPublishedYear
				+ ", comicHero=" + comicHero + ", author_id=" + author_id + "]";
	}
	
	
	
}
