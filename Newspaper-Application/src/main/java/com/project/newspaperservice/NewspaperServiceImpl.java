package com.project.newspaperservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.dto.NewspaperDTO;
import com.project.entity.Newspaper;
import com.project.newspaperDAO.NewspaperDAO;
@Service
public class NewspaperServiceImpl implements NewspaperService {
static final Logger logger=Logger.getLogger(NewspaperServiceImpl.class);
	@Autowired
	private NewspaperDAO newspaperDao;
	private HashMap<String, String> map = new HashMap<String, String>();
	
	public NewspaperServiceImpl() {
//		System.out.println(this.getClass().getSimpleName()+" Object is created..");
		logger.info("Object is created: "+this.getClass().getName());
	}
	

	public HashMap<String, String> getMap() {
		return map;
	}


	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}


	@Override
	public boolean validateNewspaperDTO(NewspaperDTO newspaperdto) {
//		System.out.println("Involked validateNewspaperDTO method......");
		logger.info("involked validate newspaper DTO()");
		boolean flag=false;
		if(newspaperdto.getNewsPaperName()!=null &!newspaperdto.getNewsPaperName().isEmpty()) {
			flag=true;
			
		}
		else {
			flag=false;
//			System.out.println("Newspaper name is invalid..");
			logger.info("newspaper name is invalid");
			return flag;
		}
		if(newspaperdto.getPrice()>0) {
			flag=true;
		}
		else {
			flag=false;
//			System.out.println("Newspaper price is invalid");
			logger.info("newspaper price is invalid");
			return flag;
		}
		if(newspaperdto.getLanguage()!=null &!newspaperdto.getLanguage().isEmpty()) {
			flag=true;
		}
		else {
			flag=false;
//			System.out.println("Newspaper language is invalid.");
			logger.info("newspaper language is invalid");
			return flag;
		}
		if(newspaperdto.getNoOfPages()>0) {
			flag=true;
			
		}
		else {
			flag=false;
//			System.out.println("Newspaper no of pages is invalid");
			logger.info("newspaper no of pages is invalid,,,,");
			return flag;
		}
		return flag;
	}

	@Override
	public boolean saveNewspaperDTO(NewspaperDTO newspaperdto) {
		Newspaper newspaper=new Newspaper();
		BeanUtils.copyProperties(newspaperdto, newspaper);
		boolean result=this.newspaperDao.saveNewspaperEntity(newspaper);
		logger.debug("add newspaper result: "+result);
		return result;
	}

	@Override
	public boolean validateNewsPaperName(String NewsPaperName) {
//		System.out.println("Invloked validate newspaper name method");
		logger.info("involked validate newspaperName()");
		boolean flag=false;
		if(NewsPaperName!=null &&! NewsPaperName.isEmpty() ) {
			flag=true;
			return flag;
		}
		else {
			flag=false;
//			System.out.println("Newspaper name is invalid");
			logger.info("newspaper name is invalid");
			return flag;
		}
		
	}

	@Override
	public List<Object> getNewspaperName(String NewspaperName) {
//		System.out.println("involked get newspaper name method..");
		logger.info("involked get newspaper name()");
		List<Object> newspaperContainer=null;
		List<Newspaper> newspaperEntityContainer=this.newspaperDao.getNewspaperEntity(NewspaperName);
		if(newspaperEntityContainer!=null) {
			return newspaperContainer=new ArrayList<Object>(newspaperEntityContainer);
		}
		return newspaperContainer;
//		NewspaperDTO newspaperDto=new NewspaperDTO();
//		BeanUtils.copyProperties(NewspaperName, newspaperDto);
		
	}

	@Override
	public boolean ValidateNewspaperLangauge(String Langauge) {
//	System.out.println("involked validate Language method");
		logger.info("involked validate newspaper language ()");
	boolean flag=false;
	if(Langauge!=null &&! Langauge.isEmpty()) {
		flag=true;
		return flag;
	}
	else {
		flag=false;
//		System.out.println("Language is not valid..");
		logger.info("language is not valid");
		return flag;
	}
	
		
	}

	@Override
	public NewspaperDTO getNewspaperLangauge(String Langauge) {
//		System.out.println("involked get newspaperLanguage method...");
		logger.info("involked get newspaper language ()");
		Newspaper entity=this.newspaperDao.getnewspaperEntity(Langauge);
		if(entity!=null) {
			NewspaperDTO dto=new NewspaperDTO();
			BeanUtils.copyProperties(entity, dto);
			logger.debug(dto);
			return dto;
		}
		return null;
	}

	
	@Override
	public List<Object> getAllNewspaperEntity() {
//		System.out.println("Invoked getAllNewsPaper()");
		logger.info("involked get all newspaper()");
		List<Object> newsPapercontainer = null;
		List<Newspaper> NewsPaperEntityContainer = this.newspaperDao.getAllNesapeperEntity();

		if (NewsPaperEntityContainer != null) {
			return newsPapercontainer=new ArrayList<Object>(NewsPaperEntityContainer);

		}

		return newsPapercontainer;
		
	}

	@Override
	public boolean deleteNewspaperEntity(String newsPaperName) {
//		System.out.println("delete newspaper method is involked");
		logger.info("involked delete newspaper entity()");
		boolean newspaper=this.newspaperDao.deleteNewspaperEntity(newsPaperName);
		
		return newspaper;
	}

	@Override
	public boolean updateNewspaperEntity(NewspaperDTO newspaperDto) {
//		System.out.println("involked update newspaper entity method for service()");
		logger.info("involked update newspaper entity () for service");
		boolean entity=this.newspaperDao.updateNewspaperEntity(newspaperDto);
		return entity;
	}

	@Override
	public NewspaperDTO getNewspaperDto(String newsPaperName) {
//		System.out.println("Invoked getNewsPaperDTO()");
		logger.info("involked get NewspaperDato()");
		List<Newspaper> newsPaperEntity = this.newspaperDao.getNewspaperEntity(newsPaperName);

		if (newsPaperEntity != null) {
			NewspaperDTO newsPaperDTO = new NewspaperDTO();
			BeanUtils.copyProperties(newsPaperEntity, newsPaperDTO);
			return newsPaperDTO;
		} else {
			return null;
		}
	}

}
