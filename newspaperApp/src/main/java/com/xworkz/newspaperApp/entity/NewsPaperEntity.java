package com.xworkz.newspaperApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "newspaper_table")
@NamedQueries({
		@NamedQuery(name = "NewsPaperEntity.getNewsPaperEntityByName", query = "from NewsPaperEntity where newsPaperName=:Name"),
		@NamedQuery(name = "NewsPaperEntity.getNewsPaperEntityByLanguage", query = "from NewsPaperEntity where language=:LANGUAGE"),
		@NamedQuery(name="getAllNewsPaper",query="from NewsPaperEntity"),
		@NamedQuery(name="deleteNewsPaper",query="from NewsPaperEntity where newsPaperName=:name"),
		@NamedQuery(name="updateNewsPaperEntity",query="update NewsPaperEntity set newsPaperName=:Name,price=:Price,language=:Language,noOfPages=:NoOfPages where newsPaperId=:Id")
})
/*@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
OR @Data
*/

@Data
public class NewsPaperEntity implements java.io.Serializable {

	@Id
	@GeneratedValue(generator = "abc" )
	@GenericGenerator(name = "abc",strategy = "increment")
	@Column(name = "NEWSPAPER_ID")
	private int newsPaperId;

	@Column(name = "NEWSPAPER_NAME")
	private String newsPaperName;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "LANGUAGE")
	private String language;

	@Column(name = "NO_OF_PAGES")
	private int noOfPages;

}
