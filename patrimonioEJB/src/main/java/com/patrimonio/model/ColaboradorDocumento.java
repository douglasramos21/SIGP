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
@Table(schema = "public", name = "colaborador_documento")
public class ColaboradorDocumento extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public ColaboradorDocumento() {
	}

	/**
	 * 
	 */
	private TipoDocumento tipoDocumento;
	private TipoVisto tipoVisto;
	private String numDocumento;
	private Date dataEmissao;
	private Date dataValidade;
	private Provincia localEmissao;
	private String classificacaoDocumento;
	private Colaborador colaborador;

	/**
	 * 
	 * M�todos
	 */

	/**
	 * 
	 * Columns
	 */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_colaborador")
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Transient
	public String getDataEmissaoFormatada() {
		return Utils.dataFormatPt(getDataEmissao());
	}

	@Transient
	public String getDataValidadeFormatada() {
		return Utils.dataFormatPt(getDataValidade());
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_documento")
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "num_documento")
	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	@Column(name = "data_emissao")
	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@Column(name = "data_validade")
	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	public Provincia getLocalEmissao() {
		return localEmissao;
	}

	public void setLocalEmissao(Provincia localEmissao) {
		this.localEmissao = localEmissao;
	}

	@Column(name = "class_documento")
	public String getClassificacaoDocumento() {
		return classificacaoDocumento;
	}

	public void setClassificacaoDocumento(String classificacaoDocumento) {
		this.classificacaoDocumento = classificacaoDocumento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_visto")
	public TipoVisto getTipoVisto() {
		return tipoVisto;
	}

	public void setTipoVisto(TipoVisto tipoVisto) {
		this.tipoVisto = tipoVisto;
	}

}
