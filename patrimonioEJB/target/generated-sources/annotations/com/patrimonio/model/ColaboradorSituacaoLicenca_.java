package com.patrimonio.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ColaboradorSituacaoLicenca.class)
public abstract class ColaboradorSituacaoLicenca_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<ColaboradorSituacaoLicenca, Date> dataLicenca;
	public static volatile SingularAttribute<ColaboradorSituacaoLicenca, Date> dataRetorno;
	public static volatile SingularAttribute<ColaboradorSituacaoLicenca, TipoLicenca> tipoLicenca;
	public static volatile SingularAttribute<ColaboradorSituacaoLicenca, ColaboradorSituacao> colaboradorSituacao;
	public static volatile SingularAttribute<ColaboradorSituacaoLicenca, String> observacao;
	public static volatile SingularAttribute<ColaboradorSituacaoLicenca, Colaborador> colaborador;

}

