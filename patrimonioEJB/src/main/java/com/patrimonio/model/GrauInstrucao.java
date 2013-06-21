package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "grau_instrucao")
public class GrauInstrucao extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public GrauInstrucao() {
	}

	/**
	 * 
	 */
	private String nome;

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

	public void setNome(String nome) {
		this.nome = nome;
	}

}
