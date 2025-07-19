package com.project.newspaperservice;

import java.util.List;

import com.project.dto.NewspaperDTO;

public interface NewspaperService {
	public boolean validateNewspaperDTO(NewspaperDTO newspaperdto);
	 public boolean saveNewspaperDTO(NewspaperDTO newspaperdto);
	 boolean validateNewsPaperName(String NewsPaperName);
	 public List<Object> getNewspaperName(String NewspaperName);
	 NewspaperDTO getNewspaperDto(String newsPaperName);
	 boolean ValidateNewspaperLangauge(String Langauge);
	public  NewspaperDTO getNewspaperLangauge(String Langauge);
	List<Object> getAllNewspaperEntity();
	boolean deleteNewspaperEntity(String newsPaperName);
	boolean updateNewspaperEntity(NewspaperDTO newspaperDto);

}
