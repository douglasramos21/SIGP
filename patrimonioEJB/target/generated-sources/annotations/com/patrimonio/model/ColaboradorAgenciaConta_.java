package com.patrimonio.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ColaboradorAgenciaConta.class)
public abstract class ColaboradorAgenciaConta_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<ColaboradorAgenciaConta, Agencia> agencia;
	public static volatile SingularAttribute<ColaboradorAgenciaConta, String> numSwift;
	public static volatile SingularAttribute<ColaboradorAgenciaConta, String> numIbam;
	public static volatile SingularAttribute<ColaboradorAgenciaConta, String> numConta;
	public static volatile SingularAttribute<ColaboradorAgenciaConta, Colaborador> colaborador;

}

