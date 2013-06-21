package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "colaborador_situacao")
public class ColaboradorSituacao extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public ColaboradorSituacao() {
	}

	/**
	 * 
	 */
	private String nome;
	private Integer sigla;

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

	@Column(name = "sigla")
	public Integer getSigla() {
		return sigla;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(Integer sigla) {
		this.sigla = sigla;
	}

}
