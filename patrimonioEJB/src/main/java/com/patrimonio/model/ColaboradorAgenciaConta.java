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
@Table(schema = "public", name = "colaborador_agencia_conta")
public class ColaboradorAgenciaConta extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public ColaboradorAgenciaConta() {
	}

	/**
	 * 
	 */
	private Agencia agencia;
	private String numConta;
	private String numSwift;
	private String numIbam;
	private Colaborador colaborador;

	/**
	 * 
	 * M�todos
	 */

	/**
	 * 
	 * Columns
	 */
	@Column(name = "num_conta")
	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agencia")
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@Column(name = "num_swift")
	public String getNumSwift() {
		return numSwift;
	}

	public void setNumSwift(String numSwift) {
		this.numSwift = numSwift;
	}

	@Column(name = "num_ibam")
	public String getNumIbam() {
		return numIbam;
	}

	public void setNumIbam(String numIbam) {
		this.numIbam = numIbam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colaborador")
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
}
