package com.xworkz.newspaperApp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xworkz.newspaperApp.NewsPaperDTO;
import com.xworkz.newspaperApp.entity.NewsPaperEntity;

public interface NewsPaperService {

	Map<String, String> map = new HashMap<String, String>();

	boolean validateNewsPaperDTO(NewsPaperDTO newsPaperDTO);

	boolean saveNewsPaperDTO(NewsPaperDTO newsPaperDTO);

	boolean validateNewsPaperName(String newsPaperName);

	NewsPaperDTO getNewsPaperDTO(String newsPaperName);
	
	List<Object> getAllNewsPaper();
	
	boolean deleteNewsPaper(String newsPaperName);
	
	boolean updateNewsPaper(NewsPaperDTO newsPaperDTO );

//	boolean validateNewsPaperLanguage(String language);

//	NewsPaperDTO getNewsPaperDTOByLanguage(String language);

}
