package com.patrimonio.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ColaboradorDocumento.class)
public abstract class ColaboradorDocumento_ extends com.patrimonio.master.EntityBean_ {

	public static volatile SingularAttribute<ColaboradorDocumento, Date> dataEmissao;
	public static volatile SingularAttribute<ColaboradorDocumento, Date> dataValidade;
	public static volatile SingularAttribute<ColaboradorDocumento, TipoDocumento> tipoDocumento;
	public static volatile SingularAttribute<ColaboradorDocumento, String> numDocumento;
	public static volatile SingularAttribute<ColaboradorDocumento, Provincia> localEmissao;
	public static volatile SingularAttribute<ColaboradorDocumento, String> classificacaoDocumento;
	public static volatile SingularAttribute<ColaboradorDocumento, Colaborador> colaborador;

}

