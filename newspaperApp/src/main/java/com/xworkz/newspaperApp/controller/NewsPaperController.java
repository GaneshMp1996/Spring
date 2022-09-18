package com.xworkz.newspaperApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.newspaperApp.NewsPaperDTO;
import com.xworkz.newspaperApp.entity.NewsPaperEntity;
import com.xworkz.newspaperApp.service.NewsPaperService;

//Handler Methods
@Controller
@RequestMapping("/")
public class NewsPaperController {

	@Autowired
	private NewsPaperService newsPaperService;

	public NewsPaperController() {
		System.out.println(this.getClass().getSimpleName() + " Created");
	}

	@RequestMapping("/submitnewspaper.do")
	public String onSubmitClicked(Model model,@ModelAttribute NewsPaperDTO newsPaperDTO ) {
		System.out.println("Invoked onSubmitClicked()");

		if (this.newsPaperService.validateNewsPaperDTO(newsPaperDTO)) {
		if (newsPaperDTO.getNewsPaperId() == 0) {
				boolean isSaved = this.newsPaperService.saveNewsPaperDTO(newsPaperDTO);
				if (isSaved) {
					model.addAttribute("validateMessage", "NewsPaper details have been saved successfully...Thank You");
				} else {
					model.addAttribute("validateMessage", "Could not save the data, Try Again..");
				}
		} else {
				boolean updatedNewsPaper = this.newsPaperService.updateNewsPaper(newsPaperDTO);
				if (updatedNewsPaper) {

					model.addAttribute("validateMessage", "NewsPaper details updated successfully");
					return "getAllNewsPaper.do";
				} else {
					model.addAttribute("validateMessage", "Could not update the data, Try Again..");
					return "getAllNewsPaper.do";
				}
			}
		} else {
			Map<String, String> map = this.newsPaperService.map;
			model.addAttribute("validateNewsPaperName", map.get("NEWSPAPERNAME"));
			model.addAttribute("validateLanguage", map.get("LANGUAGE"));
			model.addAttribute("validatePrice", map.get("PRICE"));
			model.addAttribute("validateNoOfPages", map.get("NOOFPAGES"));

		}
		return "/save.jsp";
	}

	@RequestMapping("/searchNewsPaper.do")
	public String searchNewsPaper(@RequestParam(value = "searchNewsPaper", required = true) String searchNewsPaper,
			String language, Model model) {
		System.out.println("Invoked searchNewsPaper()");

		if (this.newsPaperService.validateNewsPaperName(searchNewsPaper)) {
			NewsPaperDTO newsPaperDTO = this.newsPaperService.getNewsPaperDTO(searchNewsPaper);
			if (newsPaperDTO != null) {
				model.addAttribute("NEWSPAPERNAME", newsPaperDTO.getNewsPaperName());
				model.addAttribute("PRICE", newsPaperDTO.getPrice());
				model.addAttribute("LANGUAGE", newsPaperDTO.getLanguage());
				model.addAttribute("NOOFPAGES", newsPaperDTO.getNoOfPages());
				return "/search.jsp";
			} else {
				model.addAttribute("NOTFOUND", " NewsPaper Details not found");
				return "/search.jsp";
			}

		} else {
			model.addAttribute("searchValidationMessage", "Invalid newspaper,try again");
		}
		return "/search.jsp";
	}

	@RequestMapping("/getAllNewsPaper.do")
	public String onGetAllNewsPaperClicked(Model model) {
		System.out.println("Invoked onGetAllNewsPaperClicked()");
		List<Object> allNewspaper = this.newsPaperService.getAllNewsPaper();
		model.addAttribute("ListOfNewsPaper", allNewspaper);

		return "/get.jsp";

	}

	@RequestMapping("/deleteNewsPaper.do")
	public String onClickDeleteNewsPaper(@RequestParam(value = "newsPaperName", required = false) String newsPaperName,
			Model model) {
		System.out.println("Invoked onClickDeleteNewsPaper() ");
		boolean result = this.newsPaperService.validateNewsPaperName(newsPaperName);
		if (result) {
			boolean isDeleted = this.newsPaperService.deleteNewsPaper(newsPaperName);
			if (isDeleted) {
				model.addAttribute("validateDeleteMessage", "NewsPaper details deleted successfully...Thank You");
			} else {
				model.addAttribute("validateDeleteMessage", "Data is not available..");
			}
		} else {
			model.addAttribute("validateDeleteMessage", "Enter valid newsPaperName");
		}
		return "/delete.jsp";

	}

	@RequestMapping("/updateNewsPaper.do")
	public String onClickUpdateNewsPaper(@RequestParam("newsPaperName") String newsPaperName, Model model) {
		System.out.println("Invoked onClickUpdateNewsPaper()");
		NewsPaperDTO newsPaperDTO = this.newsPaperService.getNewsPaperDTO(newsPaperName);
		System.out.println("newsPaperDTO:-- " + newsPaperDTO);
		model.addAttribute("newspaper", newsPaperDTO);
		return "/update.jsp";
	}

	/*
	 * @RequestMapping("/searchNewsPaper.do") public String
	 * onCLickSearchByLanguage(@RequestParam String language, Model model) {
	 * System.out.println("Invoked onCLickSearch()"); if
	 * (this.newsPaperService.validateNewsPaperLanguage(language)) { else if
	 * (this.newsPaperService.validateNewsPaperLanguage(language)) { NewsPaperDTO
	 * byLanguage = this.newsPaperService.getNewsPaperDTOByLanguage(language); if
	 * (byLanguage != null) { model.addAttribute("NEWSPAPERNAME",
	 * byLanguage.getNewsPaperName()); model.addAttribute("PRICE",
	 * byLanguage.getPrice()); model.addAttribute("LANGUAGE",
	 * byLanguage.getLanguage()); model.addAttribute("NOOFPAGES",
	 * byLanguage.getNoOfPages()); return "/welcome.jsp"; } else {
	 * model.addAttribute("NOTFOUND", " NewsPaper Details not found"); return
	 * "/welcome.jsp"; }
	 * 
	 * } else { model.addAttribute("searchValidationMessage",
	 * "Invalid newspaper,try again"); } return "/welcome.jsp"; }
	 */
}
