package com.project.newspaperDAO;

import java.util.List;

import com.project.dto.NewspaperDTO;
import com.project.entity.Newspaper;

public interface NewspaperDAO {
	public boolean saveNewspaperEntity(Newspaper newspaper);
	public List<Newspaper> getNewspaperEntity(String NewspaperName);
	public Newspaper getnewspaperEntity(String Language);
	public List<Newspaper> getAllNesapeperEntity();
	public boolean deleteNewspaperEntity(String newsPaperName);
	public boolean updateNewspaperEntity(NewspaperDTO newspaperdto);

}
