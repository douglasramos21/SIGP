package com.patrimonio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "colaborador_situacao_licenca")
public class ColaboradorSituacaoLicenca extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	/**
	 * 
	 */
	private ColaboradorSituacao colaboradorSituacao;
	private Colaborador colaborador;
	private Date dataLicenca;
	private Date dataRetorno;
	private TipoLicenca tipoLicenca;
	private String observacao;

	/**
	 * 
	 * M�todos
	 */

	/**
	 * 
	 * Columns
	 */

	public ColaboradorSituacaoLicenca() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colaborador")
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Column(name = "data_licenca")
	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	@Column(name = "data_retorno")
	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	@Column(name = "observacao")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colaborador_situacao")
	public ColaboradorSituacao getColaboradorSituacao() {
		return colaboradorSituacao;
	}

	public void setColaboradorSituacao(ColaboradorSituacao colaboradorSituacao) {
		this.colaboradorSituacao = colaboradorSituacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_licenca")
	public TipoLicenca getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(TipoLicenca tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

}
