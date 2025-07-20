package com.project.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "newspaperdetails")
@NamedQuery(name = "Newspaper.getNewsPaperObject", query = "from Newspaper where newsPaperName=:name")
@NamedQuery(name = "Newspaper.getLanguageObject", query = "from Newspaper where language=:name")
@NamedQuery(name = "Newspaper.getAllEntity", query = "from Newspaper")
@NamedQuery(name = "deleteNewspaperEntity", query = "from Newspaper where newsPaperName=:name")
@NamedQuery(name = "updateNewspaperEntity", query = "update Newspaper set price=:Price, language=:Language, noOfPages=:NoOfPages where newsPaperName=:Name")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Newspaper implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NEWSPAPER_ID")  // CHAR(4), primary key
	private int id;

	@Column(name = "NEWSPAPER_NAME")
	private String newsPaperName;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "LANGUAGE")
	private String language;

	@Column(name = "NO_OF_PAGES")
	private int noOfPages;
}
