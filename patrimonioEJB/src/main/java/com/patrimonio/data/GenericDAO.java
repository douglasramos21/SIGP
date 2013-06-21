package com.patrimonio.data;

import java.io.Serializable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

import com.patrimonio.master.EntityBean;

public abstract class GenericDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("patrimonioPU");

	protected EntityManager em = emf.createEntityManager();

	// DataSource ds = null;
	Context ctx = null;
	UserTransaction ut = null;

	public GenericDAO() {
		try {
			ctx = new InitialContext();
			ut = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
			// ds = (javax.sql.DataSource)
			// ctx.lookup("java:jboss/datasources/postgresDS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void beginTransaction() {
		em = emf.createEntityManager();

		em.getTransaction().begin();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void rollback() {
		em.getTransaction().rollback();
	}

	public void closeTransaction() {
		em.close();
	}

	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	public void flush() {
		em.flush();
	}

	public void joinTransaction() {
		// em = emf.createEntityManager();
		em.joinTransaction();
	}

	public void save(EntityBean entity) throws Exception {

		try {
			ut.begin();
			joinTransaction();
			if (entity.getId() == null) {
				System.out.println("NOVO");
				em.persist(entity);
			} else {
				System.out.println("UPDATE");
				em.merge(entity);
			}
		} finally {
			ut.commit();
		}

	}

	public EntityBean delete(EntityBean entity) throws Exception {
		try {
			EntityBean entityToBeRemoved = em.merge(entity);
			ut.begin();
			joinTransaction();
			em.remove(entityToBeRemoved);
			
			return entity;
		} finally {
			ut.commit();
		}

	}

	// public EntityBean update(EntityBean entity) {
	// beginTransaction();
	// commitAndCloseTransaction();
	// return em.merge(entity);
	// }

	public EntityBean findById(Class<? extends EntityBean> entityClass, int entityID) {
		return em.find(entityClass, entityID);
	}

	// Using the unchecked because JPA does not have a
	// em.getCriteriaBuilder().createQuery()<T> method
	public List<? extends EntityBean> findAll(Class<? extends EntityBean> entityClass) {
		return em.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t", entityClass).getResultList();
	}

	// private void populateQueryParameters(Query query, Map<String, Object>
	// parameters) {
	// for (Entry<String, Object> entry : parameters.entrySet()) {
	// query.setParameter(entry.getKey(), entry.getValue());
	// }
	// }
}