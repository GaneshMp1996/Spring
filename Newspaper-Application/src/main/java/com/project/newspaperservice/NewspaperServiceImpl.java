package com.project.newspaperservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.NewspaperDTO;
import com.project.entity.Newspaper;
import com.project.newspaperDAO.NewspaperDAO;

@Service
public class NewspaperServiceImpl implements NewspaperService {

	private static final Logger logger = LoggerFactory.getLogger(NewspaperServiceImpl.class);

	@Autowired
	private NewspaperDAO newspaperDao;

	public HashMap<String, String> map = new HashMap<>();

	public NewspaperServiceImpl() {
		logger.info("Object is created: {}", this.getClass().getName());
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	@Override
	public boolean validateNewspaperDTO(NewspaperDTO newspaperDto) {
		logger.info("Invoked validateNewspaperDTO()");
		boolean flag;

		if (newspaperDto.getNewsPaperName() != 0) {
			flag = true;
		} else {
			flag = false;
			logger.warn("Newspaper Name is invalid");
			return flag;
		}

		if (newspaperDto.getPrice() > 0) {
			flag = true;
		} else {
			flag = false;
			logger.warn("Newspaper price is invalid");
			return flag;
		}

		if (newspaperDto.getLanguage() != null && !newspaperDto.getLanguage().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			logger.warn("Newspaper Language is invalid");
			return flag;
		}

		if (newspaperDto.getNoOfPages() > 0) {
			flag = true;
		} else {
			flag = false;
			logger.warn("Newspaper No of Pages is invalid");
			return flag;
		}

		return flag;
	}

	@Override
	public boolean saveNewspaperDTO(NewspaperDTO newspaperDto) {
		logger.info("Invoked saveNewspaperDTO()");
		Newspaper newspaper = new Newspaper();
		BeanUtils.copyProperties(newspaperDto, newspaper);
		return newspaperDao.saveNewspaperEntity(newspaper);
	}

	@Override
	public boolean validateNewsPaperName(String NewsPaperName) {
		logger.info("Invoked validateNewsPaperName()");
		boolean flag = NewsPaperName != null && !NewsPaperName.isEmpty();
		if (!flag) logger.warn("Newspaper name is invalid");
		return flag;
	}

	@Override
	public List<Object> getNewspaperName(String NewspaperName) {
		logger.info("Invoked getNewspaperName()");
		List<Newspaper> entities = newspaperDao.getNewspaperEntity(NewspaperName);
		return entities != null ? new ArrayList<>(entities) : null;
	}

	@Override
	public boolean ValidateNewspaperLangauge(String Langauge) {
		logger.info("Invoked ValidateNewspaperLangauge()");
		boolean flag = Langauge != null && !Langauge.isEmpty();
		if (!flag) logger.warn("Language is not valid");
		return flag;
	}

	@Override
	public NewspaperDTO getNewspaperLangauge(String Langauge) {
		logger.info("Invoked getNewspaperLangauge()");
		Newspaper entity = newspaperDao.getnewspaperEntity(Langauge);
		if (entity != null) {
			NewspaperDTO dto = new NewspaperDTO();
			BeanUtils.copyProperties(entity, dto);
			logger.debug("Mapped DTO: {}", dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<Object> getAllNewspaperEntity() {
		logger.info("Invoked getAllNewspaperEntity()");
		List<Newspaper> entities = newspaperDao.getAllNesapeperEntity();
		return entities != null ? new ArrayList<>(entities) : null;
	}

	@Override
	public boolean deleteNewspaperEntity(String newsPaperName) {
		logger.info("Invoked deleteNewspaperEntity()");
		return newspaperDao.deleteNewspaperEntity(newsPaperName);
	}

	@Override
	public boolean updateNewspaperEntity(NewspaperDTO newspaperDto) {
		logger.info("Invoked updateNewspaperEntity()");
		return newspaperDao.updateNewspaperEntity(newspaperDto);
	}

	@Override
	public NewspaperDTO getNewspaperDto(String newsPaperName) {
		logger.info("Invoked getNewspaperDto()");
		List<Newspaper> entities = newspaperDao.getNewspaperEntity(newsPaperName);
		if (entities != null && !entities.isEmpty()) {
			NewspaperDTO dto = new NewspaperDTO();
			BeanUtils.copyProperties(entities.get(0), dto);
			return dto;
		}
		return null;
	}
}
