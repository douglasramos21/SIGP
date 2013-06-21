package com.patrimonio.master;

import java.util.List;

public abstract class BusinessProcess {
	
	
	public abstract EntityBean delete(EntityBean entity) throws Exception;

	public abstract void save(EntityBean entity) throws Exception;

	public abstract List<? extends EntityBean> findAll(Class<? extends EntityBean> entityClass);
	
	public abstract List<? extends EntityBean> findById(Class<? extends EntityBean> entityClass, int entityId);


}