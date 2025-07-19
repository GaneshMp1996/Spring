package com.project.newspaperDAO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dto.NewspaperDTO;
import com.project.entity.Newspaper;

@Component
public class NewspaperDaoImpl implements NewspaperDAO {
	static final Logger logger = Logger.getLogger(NewspaperDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public NewspaperDaoImpl() {
		//		System.out.println(this.getClass().getSimpleName()+"Object created");
		logger.info("Object is created: " + this.getClass().getName());

	}

	@Override
	public boolean saveNewspaperEntity(Newspaper newspaper) {
		//		System.out.println("Involked save Newspaper Entity..");
		logger.info("involked save newspaper()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(newspaper);
			session.getTransaction().commit();
			//			System.out.println("Newspaper Details has been saved");
			logger.debug(newspaper + "Newsppaper Details saved sucessfully,,");
			return true;

		} catch (HibernateException e) {
//			System.out.println(e.getMessage());
			logger.info(e.getMessage());

		} finally {
			if (session != null) {
				session.close();
				logger.info("session is closed,,,,,,,");
			} else {
				//				System.out.println("Session is not closed");
				logger.info("session is not closed,,,,,,,,");
			}
		}
		return false;
	}

	@Override
	public List<Newspaper> getNewspaperEntity(String NewspaperName) {
//		System.out.println("Invoked getPaperEntity()");
		logger.info("involked get newspaper Entity()");

		Session session = null;
		try {
			session = sessionFactory.openSession();
			org.hibernate.query.Query<Newspaper> query = session.getNamedQuery("Newspaper.getNewsPaperObject");
			query.setParameter("name", NewspaperName);
			List<Newspaper> newspaperEntity = query.list();
			//			System.out.println("Found newsPaperName" + newspaperEntity);
			logger.debug("Newspaper Entity: " + newspaperEntity);
			if (newspaperEntity != null) {
				return newspaperEntity;
			} else {
				//				System.out.println("newsPaperName not found");
				logger.info("Newspaper name not found,,,,,,,,");
				return null;
			}
		} catch (HibernateException e) {
			//			System.out.println("inside catch block exception");
			//			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		}
		if (session != null) {
			session.close();
			logger.info("session is closed");
		} else {
			//			System.out.println("Connection is not closed");
			logger.info("session is not closed");
		}

		return null;
	}

	@Override
	public Newspaper getnewspaperEntity(String Language) {
//		System.out.println("involked get Newspaper entity");
		logger.info("involked get Newspaper ENtity()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("Newspaper.getLanguageObject");
			query.setParameter("name", Language);
			Newspaper newspaperEntity = (Newspaper) query.uniqueResult();
			if (newspaperEntity != null) {
				return newspaperEntity;
			} else {
//				System.out.println("Newspaper Language is not found");
				logger.info("Newspaper Language is not found");
				return null;
			}
		} catch (HibernateException e) {
//			System.out.println(e.getMessage());
			logger.info(e.getMessage());

		}
		if (session != null) {
			session.close();
//			System.out.println("Connection is closed");
			logger.info("session is closed,,,,,,,");
		} else {
//			System.out.println("Coneection is not closed..");
			logger.info("session is not closed");
		}
		return null;
	}

	@Override
	public List<Newspaper> getAllNesapeperEntity() {
//		System.out.println("Involked get all newspaper Entity..");
		logger.info("involked get all newspaper entity()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Newspaper> query = session.getNamedQuery("Newspaper.getAllEntity");
			List<Newspaper> list = query.list();
			if (list != null && !list.isEmpty()) {
				logger.debug(list);
				//				System.out.println(list);
				return list;
			} else {
//				System.out.println("Table is empty,,,add some data..");
				logger.info("list is empty,,,,,add some data");
			}

		} catch (HibernateException e) {
//			System.out.println(e.getMessage());
			logger.info(e.getMessage());

		} finally {
			if (session != null) {
				
//				System.out.println("session is closed");
				logger.info("session is closed,,,,");
				session.close();
			} else {
//				System.out.println("Session is not closed");
				logger.info("session is not closed,,,,");
			}
		}
		return null;
	}

	@Override
	public boolean deleteNewspaperEntity(String newsPaperName) {
//		System.out.println("Involked delete newspaper entity method...");
		logger.info("involked delete newspaper entity ()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("deleteNewspaperEntity");
			query.setParameter("name", newsPaperName);
			Newspaper object = (Newspaper) query.uniqueResult();
//			System.out.println("Delete is sucessfull: " + object);
			logger.debug("delete is sucessfull: "+object);
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			return true;

		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			if (session != null) {
//				System.out.println("session is closed");
				logger.info("session is closed");
			} else {
//				System.out.println("session is not closed");
				logger.info("session is not closed,,,,");
			}
		}
		return false;
	}

	@Override
	public boolean updateNewspaperEntity(NewspaperDTO newspaperdto) {
//		System.out.println("involked update newspaper details ()");
		logger.info("involked update newspaper details()");

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("updateNewspaperEntity");
			query.setParameter("Name", newspaperdto.getNewsPaperName());
			query.setParameter("Price", newspaperdto.getPrice());
			query.setParameter("Language", newspaperdto.getLanguage());
			query.setParameter("NoOfPages", newspaperdto.getNoOfPages());

			int updated = query.executeUpdate();
			session.getTransaction().commit();
//			System.out.println("Data updated: " + updated);
			logger.debug("data is updated: "+updated);
			return true;
		} catch (HibernateException e) {
//			System.out.println(e.getMessage());
			logger.info(e.getMessage());
		} finally {
			if (session != null) {
//				System.out.println("session is closed....");
				logger.info("session is closed");
				session.close();
			} else {
//				System.out.println("session is not closed,,,,,,,,");
				logger.info("session is not closed,,,,,,,,,");
			}

		}
		return false;
	}

}
