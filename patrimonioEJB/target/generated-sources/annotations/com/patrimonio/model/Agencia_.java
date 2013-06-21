package com.patrimonio.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agencia.class)
public abstract class Agencia_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<Agencia, Banco> banco;
	public static volatile SingularAttribute<Agencia, String> numAgencia;
	public static volatile SingularAttribute<Agencia, String> nome;
	public static volatile SingularAttribute<Agencia, Provincia> provincia;
	public static volatile SingularAttribute<Agencia, String> endereco;

}

