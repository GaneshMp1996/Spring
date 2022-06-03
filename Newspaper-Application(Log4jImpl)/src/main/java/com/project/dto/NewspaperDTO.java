package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
//@Data


public class NewspaperDTO {
	private int id;
	private String newsPaperName;
	private double price;
	private String language;
	private int noOfPages;
	
	
	
}
