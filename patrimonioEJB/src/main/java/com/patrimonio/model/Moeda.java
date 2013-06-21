package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "moeda")
public class Moeda extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public Moeda() {
	}

	/**
	 * 
	 */
	private String nome;
	private String sigla;
	private String nomePlural;
	private Integer numCasaDecimal;

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

	@Column(name = "sigla")
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Column(name = "nomePlural")
	public String getNomePlural() {
		return nomePlural;
	}

	public void setNomePlural(String nomePlural) {
		this.nomePlural = nomePlural;
	}

	@Column(name = "num_casa_decimal")
	public Integer getNumCasaDecimal() {
		return numCasaDecimal;
	}

	public void setNumCasaDecimal(Integer numCasaDecimal) {
		this.numCasaDecimal = numCasaDecimal;
	}

}
