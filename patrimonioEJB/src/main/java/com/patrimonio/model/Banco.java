package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "banco")
public class Banco extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public Banco() {
	}

	/**
	 * 
	 */
	private String nome;
	private String codigo;

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

	@Column(name = "codigo")
	public String getCodigo() {
		return codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
