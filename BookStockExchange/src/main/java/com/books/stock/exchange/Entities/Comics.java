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
 * Comics class is considered as an entity bean so that spring creates an object
 * and manages all other things
 * 
 * @Table tells to create table with the name as Comics
 * @Data represents using lombok library so that to generate
 *       getter,setters,etc..,
 */
@Entity
@Table(name = "Comics")
//@Data
public class Comics {
	/**
	 * @Id represents publicationId will be primary key in the database
	 * @GeneratedValue represents that id should be generated automatically
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comicId;
	private String comicTitle;
	private String comicPublishedYear;
	private String comicHero;
	
	  @JsonIgnore
	  @ManyToOne 
	  private Author author;

	public Comics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comics(int comicId, String comicTitle, String comicPublishedYear, String comicHero, Author author) {
		super();
		this.comicId = comicId;
		this.comicTitle = comicTitle;
		this.comicPublishedYear = comicPublishedYear;
		this.comicHero = comicHero;
		this.author = author;
	}

	public int getComicId() {
		return comicId;
	}

	public void setComicId(int comicId) {
		this.comicId = comicId;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Comics [comicId=" + comicId + ", comicTitle=" + comicTitle + ", comicPublishedYear="
				+ comicPublishedYear + ", comicHero=" + comicHero + ", author=" + author + "]";
	}
	  
	  
	 

}
