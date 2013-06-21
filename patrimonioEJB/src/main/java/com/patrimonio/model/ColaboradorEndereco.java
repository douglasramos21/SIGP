package com.patrimonio.model;

import java.io.Serializable;

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
@Table(schema = "public", name = "colaborador_endereco")
public class ColaboradorEndereco extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public ColaboradorEndereco() {
	}

	/**
	 * 
	 */

	private String endereco;
	private Provincia provincia;
	private Colaborador colaborador;
	private Character tipoEndereco;

	/**
	 * 
	 * M�todos
	 */

	/**
	 * 
	 * Columns
	 */
	@Column(name = "endereco")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Column(name = "tipo_endereco")
	public Character getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(Character tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	@Transient
	public String getTipoEnderecoFormatado() {
		return Utils.tipoEnderecoCharForString(getTipoEndereco());
	}

	@Transient
	public void setTipoEnderecoFormatado(String tipoEnderecoFormatado) {
		this.tipoEndereco = Utils.tipoEnderecoStringForChar(tipoEnderecoFormatado);
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
