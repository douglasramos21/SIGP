package com.patrimonio.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ColaboradorDependente.class)
public abstract class ColaboradorDependente_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<ColaboradorDependente, Filiacao> filiacao;
	public static volatile SingularAttribute<ColaboradorDependente, Character> sexo;
	public static volatile SingularAttribute<ColaboradorDependente, Date> dataNascimento;
	public static volatile SingularAttribute<ColaboradorDependente, String> nome;
	public static volatile SingularAttribute<ColaboradorDependente, Colaborador> colaborador;

}

