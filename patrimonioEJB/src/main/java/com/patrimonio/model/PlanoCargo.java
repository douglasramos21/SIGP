package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "plano_cargo")
public class PlanoCargo extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public PlanoCargo() {
	}

	/**
	 * 
	 */
	private String nome;
	private Double salario;

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

	@Column(name = "salario")
	public Double getSalario() {
		return salario;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
