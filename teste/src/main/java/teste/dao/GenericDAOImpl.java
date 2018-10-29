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
		LOGGER.debug("Inserir entidade: [" + entity.getClass().getName() + "]");
		getEntityManager().persist(entity);
	}

	public T merge(T entity) {
		LOGGER.debug("Atualizar entidade: [" + entity.getClass().getName() + "]");
		return (T) getEntityManager().merge(entity);
	}

	public void delete(T entity) {
		LOGGER.debug("Remover entidade: [" + entity.getClass().getName() + "]");
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
