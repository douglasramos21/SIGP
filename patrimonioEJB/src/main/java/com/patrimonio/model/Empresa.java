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
@Table(schema = "public", name = "empresa")
public class Empresa extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public Empresa() {
	}

	/**
	 * 
	 */
	private String nome;
	private String apelido;
	private Moeda moeda;
	private boolean impostoIrt;
	private boolean impostoInss;
	private String endereco;
	private Provincia provincia;
	private Integer numContribuinte;
	private Integer numSegurancaSocial;
	private Colaborador colaboradorResponsavel;
	private Integer telefoneDDD;
	private Integer telefone;
	private String smtpServer;

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

	@Column(name = "apelido")
	public String getApelido() {
		return apelido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moeda")
	public Moeda getMoeda() {
		return moeda;
	}
	
	@Column(name = "imposto_irt")
	public boolean isImpostoIrt() {
		return impostoIrt;
	}
	
	@Column(name = "imposto_inss")
	public boolean isImpostoInss() {
		return impostoInss;
	}
	
	@Column(name = "endereco")
	public String getEndereco() {
		return endereco;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	public Provincia getProvincia() {
		return provincia;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colaborador_responsavel")
	public Colaborador getColaboradorResponsavel() {
		return colaboradorResponsavel;
	}
	
	@Column(name = "telefone_DDD")
	public Integer getTelefoneDDD() {
		return telefoneDDD;
	}
	
	@Column(name = "telefone")
	public Integer getTelefone() {
		return telefone;
	}
	
	@Column(name = "smtp_server")
	public String getSmtpServer() {
		return smtpServer;
	}
	
	@Column(name = "num_seguranca_social")
	public Integer getNumSegurancaSocial() {
		return numSegurancaSocial;
	}
	
	@Column(name = "num_contribuinte")
	public Integer getNumContribuinte() {
		return numContribuinte;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public void setColaboradorResponsavel(Colaborador colaboradorResponsavel) {
		this.colaboradorResponsavel = colaboradorResponsavel;
	}

	public void setTelefoneDDD(Integer telefoneDDD) {
		this.telefoneDDD = telefoneDDD;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public void setNumContribuinte(Integer numContribuinte) {
		this.numContribuinte = numContribuinte;
	}

	public void setNumSegurancaSocial(Integer numSegurancaSocial) {
		this.numSegurancaSocial = numSegurancaSocial;
	}

	public void setImpostoInss(boolean impostoInss) {
		this.impostoInss = impostoInss;
	}
	
	public void setImpostoIrt(boolean impostoIrt) {
		this.impostoIrt = impostoIrt;
	}


}
