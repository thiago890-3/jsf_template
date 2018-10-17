package teste.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class GenericDAOImpl<T> {

	private static final Logger LOGGER = LogManager.getLogger(GenericDAOImpl.class);

	@PersistenceContext
	private EntityManager em;

	public void persist(T entity) {
		LOGGER.error("Inserir entidade: [" + entity.getClass().getName() + "]");
		getEntityManager().persist(entity);
	}

	public T merge(T entity) {
		return (T) getEntityManager().merge(entity);
	}

	public void delete(T entity) {
		getEntityManager().remove(entity);
	}

	public void flush() {
		getEntityManager().flush();
	}

	public void clear() {
		getEntityManager().clear();
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}
}
