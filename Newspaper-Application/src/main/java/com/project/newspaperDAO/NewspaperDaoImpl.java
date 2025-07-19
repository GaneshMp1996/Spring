package com.project.newspaperDAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dto.NewspaperDTO;
import com.project.entity.Newspaper;

@Component
public class NewspaperDaoImpl implements NewspaperDAO {

	private static final Logger logger = LoggerFactory.getLogger(NewspaperDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public NewspaperDaoImpl() {
		logger.info("{} object created", this.getClass().getSimpleName());
	}

	@Override
	public boolean saveNewspaperEntity(Newspaper newspaper) {
		logger.info("Invoked saveNewspaperEntity()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(newspaper);
			session.getTransaction().commit();
			logger.debug("Newspaper details saved successfully: {}", newspaper);
			return true;
		} catch (HibernateException e) {
			logger.error("Exception in saveNewspaperEntity: {}", e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session closed");
			} else {
				logger.warn("Session was null, not closed");
			}
		}
		return false;
	}

	@Override
	public List<Newspaper> getNewspaperEntity(String newspaperName) {
		logger.info("Invoked getNewspaperEntity() with name: {}", newspaperName);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Newspaper> query = session.getNamedQuery("Newspaper.getNewsPaperObject");
			query.setParameter("name", newspaperName);
			List<Newspaper> result = query.list();
			if (result != null && !result.isEmpty()) {
				logger.debug("Newspaper found: {}", result);
				return result;
			} else {
				logger.warn("No newspaper found with name: {}", newspaperName);
			}
		} catch (HibernateException e) {
			logger.error("Exception in getNewspaperEntity: {}", e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session closed");
			}
		}
		return null;
	}

	@Override
	public Newspaper getnewspaperEntity(String language) {
		logger.info("Invoked getnewspaperEntity() with language: {}", language);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Newspaper> query = session.getNamedQuery("Newspaper.getLanguageObject");
			query.setParameter("name", language);
			Newspaper result = query.uniqueResult();
			if (result != null) {
				logger.debug("Newspaper found: {}", result);
				return result;
			} else {
				logger.warn("No newspaper found with language: {}", language);
			}
		} catch (HibernateException e) {
			logger.error("Exception in getnewspaperEntity: {}", e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session closed");
			}
		}
		return null;
	}

	@Override
	public List<Newspaper> getAllNesapeperEntity() {
		logger.info("Invoked getAllNesapeperEntity()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Newspaper> query = session.getNamedQuery("Newspaper.getAllEntity");
			List<Newspaper> list = query.list();
			if (list != null && !list.isEmpty()) {
				logger.debug("Newspaper list: {}", list);
				return list;
			} else {
				logger.warn("No newspapers found in database");
			}
		} catch (HibernateException e) {
			logger.error("Exception in getAllNesapeperEntity: {}", e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session closed");
			}
		}
		return null;
	}

	@Override
	public boolean deleteNewspaperEntity(String newsPaperName) {
		logger.info("Invoked deleteNewspaperEntity() with name: {}", newsPaperName);
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			Query<Newspaper> query = session.getNamedQuery("deleteNewspaperEntity");
			query.setParameter("name", newsPaperName);
			List<Newspaper> entities = query.list();  // <-- changed here

			if (!entities.isEmpty()) {
				tx = session.beginTransaction();
				for (Newspaper entity : entities) {
					session.delete(entity);
					logger.debug("Deleted newspaper: {}", entity);
				}
				tx.commit();
				return true;
			} else {
				logger.warn("No newspaper found to delete with name: {}", newsPaperName);
			}
		} catch (HibernateException e) {
			logger.error("Exception in deleteNewspaperEntity: {}", e.getMessage());
			if (tx != null) tx.rollback();
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session closed");
			}
		}
		return false;
	}


	@Override
	public boolean updateNewspaperEntity(NewspaperDTO newspaperdto) {
		logger.info("Invoked updateNewspaperEntity() with DTO: {}", newspaperdto);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query<?> query = session.getNamedQuery("updateNewspaperEntity");
			query.setParameter("Name", newspaperdto.getNewsPaperName());
			query.setParameter("Price", newspaperdto.getPrice());
			query.setParameter("Language", newspaperdto.getLanguage());
			query.setParameter("NoOfPages", newspaperdto.getNoOfPages());

			int updated = query.executeUpdate();
			session.getTransaction().commit();
			logger.debug("Update successful, rows affected: {}", updated);
			return true;
		} catch (HibernateException e) {
			logger.error("Exception in updateNewspaperEntity: {}", e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				logger.info("Session closed");
			}
		}
		return false;
	}
}
