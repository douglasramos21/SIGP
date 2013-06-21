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
@Table(schema = "public", name = "agencia")
public class Agencia extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public Agencia() {
	}

	/**
	 * Atributos
	 */
	private String nome;
	private Banco banco;
	private String numAgencia;
	private String endereco;
	private Provincia provincia;
	

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_banco")
	public Banco getBanco() {
		return banco;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	public Provincia getProvincia() {
		return provincia;
	}
	
	@Column(name = "endereco")
	public String getEndereco() {
		return endereco;
	}
	
	@Column(name = "num_agencia")
	public String getNumAgencia() {
		return numAgencia;
	}
	
	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

}
