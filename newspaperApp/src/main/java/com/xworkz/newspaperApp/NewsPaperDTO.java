package com.xworkz.newspaperApp;

import lombok.Data;

@Data // Equivalent to @NoArgsConstructor @AllArgsConstructor @Setter @Getter
		// @ToString
public class NewsPaperDTO {

	private int newsPaperId;
	private String newsPaperName;
	private double price;
	private String language;
	private int noOfPages;

}
