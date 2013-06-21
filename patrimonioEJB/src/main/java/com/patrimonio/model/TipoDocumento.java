package com.patrimonio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "tipo_documento")
public class TipoDocumento extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	private String nome;
//	private List<ColaboradorDocumento> documentos = new ArrayList<ColaboradorDocumento>();

	public TipoDocumento() {

	}

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

//	@OneToMany(mappedBy = "tipoDocumento")
//	public List<ColaboradorDocumento> getDocumentos() {
//		return documentos;
//	}

//	public void setDocumentos(List<ColaboradorDocumento> documentos) {
//		this.documentos = documentos;
//	}

}
