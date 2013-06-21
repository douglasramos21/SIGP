package com.patrimonio.master;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6178523681381508976L;
	
	private Integer id;

	@Override
	public boolean equals(Object obj) {

		if (obj == null || this == null)
			return false;

		if (obj instanceof EntityBean && ((EntityBean) obj).getId() != null && this.getId() != null) {
			if (((EntityBean) obj).getId().equals(this.getId())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode() {

		int hash = 7;

		hash = 23 * hash + (getId() != null ? getId().hashCode() : 0);

		return hash;

	}

	
//	public abstract void setId(Integer id);
//	
//	public abstract Integer getId();
	public void setId(Integer id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId(){
		return this.id;
	}

}
