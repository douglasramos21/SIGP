package com.patrimonio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.patrimonio.master.EntityBean;
import com.patrimonio.utils.Utils;

@Entity
@Table(schema = "public", name = "colaborador_dependente")
public class ColaboradorDependente extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public ColaboradorDependente() {
	}

	/**
	 * 
	 */
	private String nome;
	private Colaborador colaborador;
	private Filiacao filiacao;
	private Character sexo;
	private Date dataNascimento;

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
	@JoinColumn(name = "id_colaborador")
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_filiacao")
	public Filiacao getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}

	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@Transient
	public String getDataNascimentoFormatada() {
		return Utils.dataFormatPt(getDataNascimento());
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "sexo")
	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	@Transient
	public String getSexoFormatado() {
		return Utils.sexoCharForString(getSexo());
	}

}
