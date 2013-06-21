package com.patrimonio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "competencia")
public class Competencia extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public Competencia() {
	}

	/**
	 * 
	 */
	private Date dataInicial;
	private Date dataFinal;
	private String mensagemDemonstrativo;
	private String mensagemAniversario;
	private Character estadoCompetencia;

	/**
	 * 
	 * M�todos
	 */

	/**
	 * 
	 * Columns
	 */
	@Column(name = "data_inicial")
	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	@Column(name = "data_final")
	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Column(name = "mensagem_demonstrativo")
	public String getMensagemDemonstrativo() {
		return mensagemDemonstrativo;
	}

	public void setMensagemDemonstrativo(String mensagemDemonstrativo) {
		this.mensagemDemonstrativo = mensagemDemonstrativo;
	}

	@Column(name = "mensagem_aniversario")
	public String getMensagemAniversario() {
		return mensagemAniversario;
	}

	public void setMensagemAniversario(String mensagemAniversario) {
		this.mensagemAniversario = mensagemAniversario;
	}

	@Column(name = "estado_competencia")
	public Character getEstadoCompetencia() {
		return estadoCompetencia;
	}

	public void setEstadoCompetencia(Character estadoCompetencia) {
		this.estadoCompetencia = estadoCompetencia;
	}

}
