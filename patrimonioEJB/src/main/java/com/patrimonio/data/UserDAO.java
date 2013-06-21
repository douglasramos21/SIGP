package com.patrimonio.data;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.patrimonio.master.EntityBean;

public class UserDAO extends GenericDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7610523666968576506L;
	
	// Using the unchecked because JPA does not have a
	// query.getSingleResult()<T> method
	// Swap criteria statements if you would like to try out type-safe criteria
	// queries, a new
	// feature in JPA 2.0
	// criteria.select(member).where(cb.equal(member.get(Member_.name), email));
	public EntityBean findByEmail(String email, Class<? extends EntityBean> entityClass) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<? extends EntityBean> query = cb.createQuery(entityClass);
		Root<? extends EntityBean> sm = query.from(entityClass);
		query.where(cb.equal(sm.get("email"), email));
		return em.createQuery(query).getSingleResult();
	}

}
