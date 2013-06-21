package com.patrimonio.model;

import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ColaboradorHorario.class)
public abstract class ColaboradorHorario_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<ColaboradorHorario, Time> horaManhaFim;
	public static volatile SingularAttribute<ColaboradorHorario, Time> horaNoiteInicio;
	public static volatile SingularAttribute<ColaboradorHorario, Time> horaTardeFim;
	public static volatile SingularAttribute<ColaboradorHorario, String> nome;
	public static volatile SingularAttribute<ColaboradorHorario, Time> horaNoiteFim;
	public static volatile SingularAttribute<ColaboradorHorario, Time> horaManhaInicio;
	public static volatile SingularAttribute<ColaboradorHorario, TipoHorario> tipoHorario;
	public static volatile SingularAttribute<ColaboradorHorario, Time> horaTardeInicio;
	public static volatile SingularAttribute<ColaboradorHorario, Colaborador> colaborador;

}

