package com.xworkz.newspaperApp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xworkz.newspaperApp.NewsPaperDTO;
import com.xworkz.newspaperApp.dao.NewsPaperDAO;
import com.xworkz.newspaperApp.entity.NewsPaperEntity;

//Business logic
@Service
public class NewsPaperServiceImpl implements NewsPaperService {

	@Autowired
	private NewsPaperDAO newsPaperDAO;

	public NewsPaperServiceImpl() {

		System.out.println(this.getClass().getSimpleName() + " Created");
	}

	@Override
	public boolean validateNewsPaperDTO(NewsPaperDTO newsPaperDTO) {
		System.out.println("Invoked validateNewsPaperDTO()");
		boolean flag = false;
		if (newsPaperDTO.getNewsPaperName() != null && !newsPaperDTO.getNewsPaperName().isEmpty()) {
			flag = true;	
		} else {
			flag = false;
			System.out.println("Invalid NewsPaperName");
			map.put("NEWSPAPERNAME", "Invalid NewsPaperName");
			return flag;
		}
		if (newsPaperDTO.getLanguage() != null && !newsPaperDTO.getLanguage().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid language");
			map.put("LANGUAGE", "Invalid language");

			return flag;
		}
		if (newsPaperDTO.getPrice() > 0) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid price");
			map.put("PRICE", "Invalid price");

			return flag;
		}
		if (newsPaperDTO.getNoOfPages() > 0) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Invalid noofpages");
			map.put("NOOFPAGES", "Invalid noofpages");

			return flag;
		}
		return flag;
	}

	@Override
	public boolean saveNewsPaperDTO(NewsPaperDTO newsPaperDTO) {
		NewsPaperEntity newsPaperEntity = new NewsPaperEntity();
		BeanUtils.copyProperties(newsPaperDTO, newsPaperEntity);
		boolean result = this.newsPaperDAO.saveNewsPaperEntity(newsPaperEntity);

		return result;

		/*
		 * newsPaperEntity.setNewsPaperName(newsPaperDTO.getNewsPaperName());
		 * newsPaperEntity.setPrice(newsPaperDTO.getPrice());
		 * newsPaperEntity.setLanguage(newsPaperDTO.getLanguage());
		 * newsPaperEntity.setNoOfPages(newsPaperDTO.getNoOfPages());
		 */
	}

	@Override
	public boolean validateNewsPaperName(String newsPaperName) {

		System.out.println("Invoked validateNewsPaperName()");
		boolean flag = false;
		if (!newsPaperName.isEmpty() && newsPaperName != null) {
			flag = true;
			return flag;
		} else {
			flag = false;
			System.out.println("Invalid NewsPaperName");
			return flag;
		}

	}

	@Override
	public NewsPaperDTO getNewsPaperDTO(String newsPaperName) {
		System.out.println("Invoked getNewsPaperDTO()");
		NewsPaperEntity newsPaperEntity = this.newsPaperDAO.getNewsPaperEntityByName(newsPaperName);

		if (newsPaperEntity != null) {
			NewsPaperDTO newsPaperDTO = new NewsPaperDTO();
			BeanUtils.copyProperties(newsPaperEntity, newsPaperDTO);
			return newsPaperDTO;
		} else {
			return null;
		}
	}

	@Override
	public List<Object> getAllNewsPaper() {
		System.out.println("Invoked getAllNewsPaper()");
		List<Object> newsPaperContainer = null;
		List<NewsPaperEntity> newsPaperEntityContainer = this.newsPaperDAO.getAllNewsPaper();
		if (newsPaperEntityContainer != null) {
			newsPaperContainer = new ArrayList<Object>(newsPaperEntityContainer);
			return newsPaperContainer;

		}

		return newsPaperContainer;
	}

	@Override
	public boolean deleteNewsPaper(String newsPaperName) {
		System.out.println("Invoked deleteNewsPaper()");
		boolean newsPaper = this.newsPaperDAO.deleteNewsPaper(newsPaperName);
		return newsPaper;
	}
	
	@Override
	public boolean updateNewsPaper(NewsPaperDTO newsPaperDTO) {
		System.out.println("Invoked updateNewsPaper()");
		boolean paperEntity = this.newsPaperDAO.updateNewsPaperEntity(newsPaperDTO);
		return paperEntity;
	}

	/*
	 * @Override public boolean validateNewsPaperLanguage(String language) {
	 * 
	 * System.out.println("Invoked validateNewsPaperLanguage()"); boolean flag =
	 * false; if (!language.isEmpty() && language != null) { flag = true; return
	 * flag; } else { flag = false; System.out.println("Invalid Language"); return
	 * flag; }
	 * 
	 * }
	 * 
	 * @Override public NewsPaperDTO getNewsPaperDTOByLanguage(String language) {
	 * System.out.println("Invoked getNewsPaperDTOByLanguage()"); NewsPaperEntity
	 * newsPaperEntity = this.newsPaperDAO.getNewsPaperEntityByLanguage(language);
	 * if (newsPaperEntity != null) { NewsPaperDTO dto = new NewsPaperDTO();
	 * BeanUtils.copyProperties(newsPaperEntity, dto); return dto; } else { return
	 * null; }
	 * 
	 * }
	 */
}
