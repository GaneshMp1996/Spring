package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "newspaperdetails")
@NamedQuery(name = "Newspaper.getNewsPaperObject", query = "from Newspaper where newsPaperName=:name")
@NamedQuery(name = "Newspaper.getLanguageObject", query = "from Newspaper where language=:name")
@NamedQuery(name = "Newspaper.getAllEntity", query = "from Newspaper")
@NamedQuery(name = "deleteNewspaperEntity", query = "from Newspaper where newsPaperName=:name")
@NamedQuery(name = "updateNewspaperEntity", query = "update Newspaper set price=:Price,language=:Language,noOfPages=:NoOfPages where newsPaperName=:Name")

public class Newspaper implements java.io.Serializable {
	@Id
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")
	@Column(name = "ID")
	private int id;
	//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NAME")
	private String newsPaperName;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "LANGUAGE")
	private String language;

	@Column(name = "NOOFPAGES")
	private int noOfPages;

}
