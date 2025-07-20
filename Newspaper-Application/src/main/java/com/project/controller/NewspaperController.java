package com.project.controller;

import java.util.List;

import com.project.dto.NewspaperDTO;
import com.project.newspaperservice.NewspaperService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class NewspaperController {

	private static final Logger logger = LoggerFactory.getLogger(NewspaperController.class);

	@Autowired
	private NewspaperService serviceImpl;

	public NewspaperController() {
		logger.info("Object is created: {}", this.getClass().getSimpleName());
	}

	@RequestMapping
	public String showHomePage(Model model) {
		model.addAttribute("newspaper", new NewspaperDTO());
		return "home";
	}

	@RequestMapping(value = "/news", method = RequestMethod.POST)
	public String saveNewspaper(@ModelAttribute NewspaperDTO newspaperDTO, Model model) {
		logger.info("Invoked saveNewspaper()");

		if (serviceImpl.validateNewspaperDTO(newspaperDTO)) {
			boolean isSaved = serviceImpl.saveNewspaperDTO(newspaperDTO);
			if (isSaved) {
				model.addAttribute("Name", newspaperDTO.getNewsPaperName());
				model.addAttribute("Price", newspaperDTO.getPrice());
				model.addAttribute("Language", newspaperDTO.getLanguage());
				model.addAttribute("NoOfPages", newspaperDTO.getNoOfPages());
				model.addAttribute("ValidateMessage", "Data is saved successfully");
				logger.info("Newspaper saved successfully: {}", newspaperDTO.getNewsPaperName());
				return "NewspaperDetails";
			} else {
				model.addAttribute("ValidateMessage", "Failed to save data. Try again.");
				model.addAttribute("newspaper", newspaperDTO); // 💡 ADD THIS
				logger.warn("Failed to save newspaper data");
			}
		} else {
			model.addAttribute("ValidateMessage", "Invalid data. Please check and try again.");
			model.addAttribute("newspaper", newspaperDTO); // 💡 ADD THIS
			logger.warn("Invalid newspaper data received");
		}
		return "home";
	}


	@RequestMapping("/searchNewsPaper.abc")
	public String getNewspaperName(@RequestParam String searchNewsPaper, Model model) {
		logger.info("Invoked getNewspaperName() for: {}", searchNewsPaper);

		if (serviceImpl.validateNewsPaperName(searchNewsPaper)) {
			List<Object> newspaperList = serviceImpl.getNewspaperName(searchNewsPaper);
			model.addAttribute("ListOfNewspaper", newspaperList);
			return "ViewNewspaperDetails";
		} else {
			model.addAttribute("NotFound", "NewspaperName is not found...");
			logger.warn("Invalid or empty Newspaper name: {}", searchNewsPaper);
			return "ViewNewspaperDetails";
		}
	}

	@RequestMapping("/searchLanguage.abc")
	public String getNewspaperLanguage(@RequestParam String searchLanguage, Model model) {
		logger.info("Invoked getNewspaperLanguage() for: {}", searchLanguage);

		if (serviceImpl.ValidateNewspaperLangauge(searchLanguage)) {
			NewspaperDTO dto = serviceImpl.getNewspaperLangauge(searchLanguage);
			if (dto != null) {
				model.addAttribute("Name", dto.getNewsPaperName());
				model.addAttribute("Price", dto.getPrice());
				model.addAttribute("Language", dto.getLanguage());
				model.addAttribute("No_Of_Pages", dto.getNoOfPages());
				return "ViewNewspaperLanguage";
			} else {
				logger.warn("No data found for language: {}", searchLanguage);
			}
		} else {
			model.addAttribute("SearchValidation", "Invalid Language, try again");
			logger.warn("Invalid language input: {}", searchLanguage);
		}
		return "index";
	}

	@RequestMapping("/getAllNewsPaper.abc")
	public String getAllNewspaperEntity(Model model) {
		logger.info("Invoked getAllNewspaperEntity()");
		List<Object> allNewspapers = serviceImpl.getAllNewspaperEntity();
		model.addAttribute("ListOfNewspaper", allNewspapers);
		return "getAllNewspaperDetails";
	}

	@RequestMapping("/deleteNewspaper.abc")
	public String deleteNewspaperEntity(@RequestParam(value = "newsPaperName", required = false) String newsPaperName,
										Model model) {
		logger.info("Invoked deleteNewspaperEntity() for: {}", newsPaperName);

		if (newsPaperName == null || newsPaperName.trim().isEmpty()) {
			model.addAttribute("validationMessage", "Newspaper name must not be empty.");
			logger.warn("Attempted to delete with empty or null newspaper name.");
			return "deleteNewspaperDetails";
		}

		boolean isDeleted = serviceImpl.deleteNewspaperEntity(newsPaperName);

		if (isDeleted) {
			model.addAttribute("validateDeleteMessage", "Newspaper details deleted successfully.");
			logger.info("Deleted newspaper: {}", newsPaperName);
		} else {
			model.addAttribute("validationMessage", "Could not delete the data. Try again.");
			logger.warn("Failed to delete newspaper: {}", newsPaperName);
		}

		return "deleteNewspaperDetails";
	}


	@RequestMapping("/updateNewspaper.abc")
	public String updateNewspaper(@RequestParam(value = "newsPaperName") String newsPaperName,
								  @ModelAttribute NewspaperDTO newspaperDto, Model model) {
		logger.info("Invoked updateNewspaperEntity() for: {}", newsPaperName);
		boolean updated = serviceImpl.updateNewspaperEntity(newspaperDto);
		logger.debug("Newspaper DTO to update: {}", newspaperDto);

		if (updated) {
			model.addAttribute("newspapername", newspaperDto.getNewsPaperName());
			model.addAttribute("price", newspaperDto.getPrice());
			model.addAttribute("language", newspaperDto.getLanguage());
			model.addAttribute("noOfPages", newspaperDto.getNoOfPages());
			model.addAttribute("Message", "Newspaper details updated successfully");
			logger.info("Updated newspaper successfully: {}", newspaperDto.getNewsPaperName());
			return "updateNewspaper";
		} else {
			model.addAttribute("errorMessage", "Data is not updated");
			logger.warn("Update failed for: {}", newspaperDto.getNewsPaperName());
			return "NewspaperDetails";
		}
	}
}
