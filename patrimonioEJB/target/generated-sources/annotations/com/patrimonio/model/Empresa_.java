package com.patrimonio.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empresa.class)
public abstract class Empresa_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<Empresa, Colaborador> colaboradorResponsavel;
	public static volatile SingularAttribute<Empresa, Boolean> impostoInss;
	public static volatile SingularAttribute<Empresa, Provincia> provincia;
	public static volatile SingularAttribute<Empresa, Integer> numContribuinte;
	public static volatile SingularAttribute<Empresa, Integer> telefoneDDD;
	public static volatile SingularAttribute<Empresa, Boolean> impostoIrt;
	public static volatile SingularAttribute<Empresa, String> smtpServer;
	public static volatile SingularAttribute<Empresa, Integer> telefone;
	public static volatile SingularAttribute<Empresa, String> nome;
	public static volatile SingularAttribute<Empresa, String> endereco;
	public static volatile SingularAttribute<Empresa, Moeda> moeda;
	public static volatile SingularAttribute<Empresa, Integer> numSegurancaSocial;
	public static volatile SingularAttribute<Empresa, String> apelido;

}

