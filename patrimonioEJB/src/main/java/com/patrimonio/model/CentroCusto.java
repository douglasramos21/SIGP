package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "centro_custo")
public class CentroCusto extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public CentroCusto() {
	}

	/**
	 * 
	 */
	private String nome;
	private Integer codigo;

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
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
