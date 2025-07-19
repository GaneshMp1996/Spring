package com.project.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.NewspaperDTO;
import com.project.newspaperservice.NewspaperServiceImpl;

@Component
@RequestMapping("/")
public class NewspaperController {
	Logger logger = Logger.getLogger(NewspaperController.class);
	
	@Autowired
	private NewspaperServiceImpl serviceImpl;

	public NewspaperController() {
		//		System.out.println(this.getClass().getSimpleName() + "object created");

		logger.info("Object is created: " + this.getClass().getName());
	}

	@RequestMapping("/news.abc")
	public String SaveNewspaper(@ModelAttribute NewspaperDTO newspaperdto, Model model) {
		//		System.out.println("Involked save newspaper method");
		logger.info("involked save newspaper()");
		if (this.serviceImpl.validateNewspaperDTO(newspaperdto)) {
			boolean isSaved = this.serviceImpl.saveNewspaperDTO(newspaperdto);
			if (isSaved) {
				model.addAttribute("Name", newspaperdto.getNewsPaperName());
				model.addAttribute("Price", newspaperdto.getPrice());
				model.addAttribute("Language", newspaperdto.getLanguage());
				model.addAttribute("No_Of_Pages", newspaperdto.getNoOfPages());
				System.out.println("Newspaper data is sucessfully saved...");
				logger.info("Newspaper details saved sucessfully");
				model.addAttribute("ValidateMessage", "Data is saved sucessfully.....");
			}

			else {
				model.addAttribute("ValidationMessage", "Invalid data,,,please check it once");
			}
		} else {
			HashMap<String, String> map = this.serviceImpl.getMap();
			model.addAttribute("validateName", map.get("NEWSPAPERNAME"));
			model.addAttribute("validatePrice", map.get("PRICE"));
			model.addAttribute("validateLanguage", map.get("LANGUAGE"));
			model.addAttribute("validatePages", map.get("NOOFPAGES"));
		}
		return "/WEB-INF/Pages/NewspaperDetails.jsp";

	}

	@RequestMapping("/searchNewsPaper.abc")
	public String getNewspaperName(@RequestParam String searchNewsPaper, Model model) {
		//		System.out.println("Invloked get newspaper name method..");
		logger.info("involked get NewspaperName()");
		if (this.serviceImpl.validateNewsPaperName(searchNewsPaper)) {
			List<Object> newspaperdto = this.serviceImpl.getNewspaperName(searchNewsPaper);
			model.addAttribute("ListOfNewspaper", newspaperdto);
			//			if (newspaperdto != null) {
			//				model.addAttribute("Name", newspaperdto.getNewsPaperName());
			//				model.addAttribute("Price", newspaperdto.getPrice());
			//				model.addAttribute("Language", newspaperdto.getLanguage());
			//				model.addAttribute("No_Of_Pages", newspaperdto.getNoOfPages());
			return "/WEB-INF/Pages/ViewNewspaperDetails.jsp";
		} else {
			model.addAttribute("NotFound", "NewspaperName is not found...");
			return "/WEB-INF/Pages/ViewNewspaperDetails.jsp";
		}

	}

	@RequestMapping("/searchLanguage.abc")
	public String getNewspaperLanguage(@RequestParam String searchLanguage, Model model) {
		//		System.out.println("Involked get newspaper language method...");
		logger.info("involked getNewspaper Language()");
		if (this.serviceImpl.ValidateNewspaperLangauge(searchLanguage)) {
			NewspaperDTO dto = this.serviceImpl.getNewspaperLangauge(searchLanguage);
			if (dto != null) {
				model.addAttribute("Name", dto.getNewsPaperName());
				model.addAttribute("Price", dto.getPrice());
				model.addAttribute("Language", dto.getLanguage());
				model.addAttribute("No_Of_Pages", dto.getNoOfPages());
				return "/WEB-INF/Pages/ViewNewspaperLanguage.jsp";
			}

		} else {
			model.addAttribute("SearchValidation", "Invalid Lanuage,,try again");
		}

		return " /WEB-INF/Pages/index.jsp";

	}

	@RequestMapping("/getAllNewsPaper.abc")
	public String getAllNewspaperEntity(Model model) {
		//		System.out.println("Involked getall newspaper entity method..");
		logger.info("involked get all newspaper Entity()");
		List<Object> allNewspaperEntity = this.serviceImpl.getAllNewspaperEntity();
		model.addAttribute("ListOfNewspaper", allNewspaperEntity);
		return "/WEB-INF/Pages/getAllNewspaperDetails.jsp";
	}

	@RequestMapping("/deleteNewspaper.abc")
	public String DeleteNewspaperEntity(@RequestParam(value = "newsPaperName", required = false) String newsPaperName,
			Model model) {
		//		System.out.println("involked delete method...");
		logger.info("involked delete Newspaper Entity");
		boolean isdeleted = this.serviceImpl.deleteNewspaperEntity(newsPaperName);
		if (isdeleted) {
			model.addAttribute("validateDeleteMessage", "Newspaper details deleted sucessfully,,,thank you");
		} else {
			model.addAttribute("validataionMessage", "could not delete the data,,,try again...");
		}
		return "/WEB-INF/Pages/deleteNewspaperDetails.jsp";
	}

	@RequestMapping("/updateNewspaper.abc")
	public String updateNewspaper(@RequestParam(value = "newsPaperName") String newsPaperName,
			@ModelAttribute NewspaperDTO newspaperDto, Model model) {
//		System.out.println("involked update newspaper Entity method..........");
		logger.info("involked update newspaper entity ()");
		boolean updated = this.serviceImpl.updateNewspaperEntity(newspaperDto);
		System.out.println("Newspaper Dto: " + newspaperDto);
		if (newspaperDto != null) {
			model.addAttribute("newspapername", newspaperDto.getNewsPaperName());
			model.addAttribute("price", newspaperDto.getPrice());
			model.addAttribute("language", newspaperDto.getLanguage());
			model.addAttribute("noOfPages", newspaperDto.getNoOfPages());

			model.addAttribute("Message", "Newspaper details updated sucessfully");
			return "/WEB-INF/Pages/updateNewspaper.jsp";
		} else {
			model.addAttribute("errorMessage", "data is not updated");
			return "/WEB-INF/Pages/NewspaperDetails.jsp";
		}

	}
}
