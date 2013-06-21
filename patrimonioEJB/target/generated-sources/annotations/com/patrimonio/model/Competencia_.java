package com.patrimonio.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Competencia.class)
public abstract class Competencia_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<Competencia, Date> dataFinal;
	public static volatile SingularAttribute<Competencia, String> mensagemDemonstrativo;
	public static volatile SingularAttribute<Competencia, Character> estadoCompetencia;
	public static volatile SingularAttribute<Competencia, Date> dataInicial;
	public static volatile SingularAttribute<Competencia, String> mensagemAniversario;

}

