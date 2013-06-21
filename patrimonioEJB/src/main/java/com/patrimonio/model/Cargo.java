package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "cargo")
public class Cargo extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public Cargo() {
	}

	/**
	 * 
	 */
	private String nome;
	private PlanoCargo planoCargo;

	/**
	 * 
	 * M�todos
	 */

	/**
	 * 
	 * Columns
	 */
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_plano_cargo")
	public PlanoCargo getPlanoCargo() {
		return planoCargo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setPlanoCargo(PlanoCargo planoCargo) {
		this.planoCargo = planoCargo;
	}

}
