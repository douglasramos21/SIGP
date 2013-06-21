package com.patrimonio.model;

import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Colaborador.class)
public abstract class Colaborador_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<Colaborador, Nacionalidade> nacionalidade;
	public static volatile ListAttribute<Colaborador, ColaboradorDocumento> documentos;
	public static volatile SingularAttribute<Colaborador, Date> dataDesligamento;
	public static volatile SingularAttribute<Colaborador, EstadoCivil> estadoCivil;
	public static volatile SingularAttribute<Colaborador, Time> horaManhaFim;
	public static volatile SingularAttribute<Colaborador, Character> sexo;
	public static volatile SingularAttribute<Colaborador, Time> horaTardeFim;
	public static volatile SingularAttribute<Colaborador, Provincia> localNascimento;
	public static volatile SingularAttribute<Colaborador, Time> horaManhaInicio;
	public static volatile SingularAttribute<Colaborador, Cargo> cargo;
	public static volatile SingularAttribute<Colaborador, String> nomeMae;
	public static volatile SingularAttribute<Colaborador, Lotacao> lotacao;
	public static volatile SingularAttribute<Colaborador, Setor> setor;
	public static volatile SingularAttribute<Colaborador, Date> dataNascimento;
	public static volatile SingularAttribute<Colaborador, Profissao> profissao;
	public static volatile SingularAttribute<Colaborador, ColaboradorRelacao> colaboradorRelacao;
	public static volatile SingularAttribute<Colaborador, Time> numMatricula;
	public static volatile SingularAttribute<Colaborador, Time> horaTardeInicio;
	public static volatile SingularAttribute<Colaborador, String> apelido;
	public static volatile SingularAttribute<Colaborador, String> nomeConjugue;
	public static volatile SingularAttribute<Colaborador, Double> salarioBase;
	public static volatile SingularAttribute<Colaborador, Time> horaNoiteInicio;
	public static volatile SingularAttribute<Colaborador, GrauInstrucao> grauInstrucao;
	public static volatile ListAttribute<Colaborador, ColaboradorEndereco> enderecos;
	public static volatile SingularAttribute<Colaborador, Date> dataAdmissao;
	public static volatile SingularAttribute<Colaborador, Time> horaNoiteFim;
	public static volatile SingularAttribute<Colaborador, ColaboradorSituacao> colaboradorSituacao;
	public static volatile SingularAttribute<Colaborador, String> observacao;
	public static volatile SingularAttribute<Colaborador, TipoHorario> tipoHorario;
	public static volatile ListAttribute<Colaborador, ColaboradorDependente> dependentes;
	public static volatile SingularAttribute<Colaborador, String> email;
	public static volatile SingularAttribute<Colaborador, Empresa> empresa;
	public static volatile SingularAttribute<Colaborador, String> nome;
	public static volatile SingularAttribute<Colaborador, String> nomePai;
	public static volatile SingularAttribute<Colaborador, String> skype;

}

