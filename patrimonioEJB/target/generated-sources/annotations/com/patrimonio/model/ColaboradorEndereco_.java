package com.patrimonio.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ColaboradorEndereco.class)
public abstract class ColaboradorEndereco_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<ColaboradorEndereco, Character> tipoEndereco;
	public static volatile SingularAttribute<ColaboradorEndereco, Provincia> provincia;
	public static volatile SingularAttribute<ColaboradorEndereco, String> endereco;
	public static volatile SingularAttribute<ColaboradorEndereco, Colaborador> colaborador;

}

