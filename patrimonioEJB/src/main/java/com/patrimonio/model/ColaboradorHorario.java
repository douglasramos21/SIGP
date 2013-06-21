package com.patrimonio.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "colaborador_horario")
public class ColaboradorHorario extends EntityBean implements Serializable {

	private static final long serialVersionUID = 8053213953493106332L;

	public ColaboradorHorario() {
	}

	/**
	 * 
	 */
	private String nome;
	private TipoHorario tipoHorario;
	private Colaborador colaborador;
	private Time horaManhaInicio;
	private Time horaManhaFim;
	private Time horaTardeInicio;
	private Time horaTardeFim;
	private Time horaNoiteInicio;
	private Time horaNoiteFim;
	

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
	@JoinColumn(name="id_colaborador")
	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_horario")
	public TipoHorario getTipoHorario() {
		return tipoHorario;
	}


	public void setTipoHorario(TipoHorario tipoHorario) {
		this.tipoHorario = tipoHorario;
	}


	@Column(name = "hora_manha_inicio")
	public Time getHoraManhaInicio() {
		return horaManhaInicio;
	}


	public void setHoraManhaInicio(Time horaManhaInicio) {
		this.horaManhaInicio = horaManhaInicio;
	}

	@Column(name = "hora_manha_fim")
	public Time getHoraManhaFim() {
		return horaManhaFim;
	}


	public void setHoraManhaFim(Time horaManhaFim) {
		this.horaManhaFim = horaManhaFim;
	}

	@Column(name = "hora_tarde_inicio")
	public Time getHoraTardeInicio() {
		return horaTardeInicio;
	}


	public void setHoraTardeInicio(Time horaTardeInicio) {
		this.horaTardeInicio = horaTardeInicio;
	}

	@Column(name = "hora_tarde_fim")
	public Time getHoraTardeFim() {
		return horaTardeFim;
	}


	public void setHoraTardeFim(Time horaTardeFim) {
		this.horaTardeFim = horaTardeFim;
	}

	@Column(name = "hora_noite_inicio")
	public Time getHoraNoiteInicio() {
		return horaNoiteInicio;
	}


	public void setHoraNoiteInicio(Time horaNoiteInicio) {
		this.horaNoiteInicio = horaNoiteInicio;
	}

	@Column(name = "hora_noite_fim")
	public Time getHoraNoiteFim() {
		return horaNoiteFim;
	}


	public void setHoraNoiteFim(Time horaNoiteFim) {
		this.horaNoiteFim = horaNoiteFim;
	}

}
