package com.patrimonio.data;

import java.io.Serializable;
import java.util.List;

import com.patrimonio.master.EntityBean;

public class ColaboradorDAO extends GenericDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7610523666968576506L;
	
	public List<? extends EntityBean> findTabsByColaborador(Class<? extends EntityBean> entityClass, int entityId) {
		return em.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t WHERE t.colaborador = "+entityId , entityClass).getResultList();
	}

}
