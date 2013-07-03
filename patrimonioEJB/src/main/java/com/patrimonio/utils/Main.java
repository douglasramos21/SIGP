package com.patrimonio.utils;

public class Main {

	// @SuppressWarnings("deprecation")
	// public static void main(String[] args) throws ParseException {
	//
	// // Map<String, Object> configOverrides = new HashMap<String, Object>();
	// // configOverrides.put("hibernate.hbm2ddl.auto", "create-drop");
	// // configOverrides.put("javax.persistence.provider",
	// // "org.hibernate.ejb.HibernatePersistence");
	// // configOverrides.put("javax.persistence.transactionType",
	// // "RESOURCE_LOCAL");
	// // configOverrides.put("javax.persistence.jdbc.user", "postgres");
	// // configOverrides.put("javax.persistence.jdbc.password", "admin");
	// // configOverrides.put("javax.persistence.jdbc.driver",
	// // "org.postgresql.Driver");
	// // configOverrides.put("javax.persistence.jdbc.url",
	// // "jdbc:postgresql://localhost:5432/postgres");
	// // configOverrides.put("hibernate.dialect",
	// // "org.hibernate.dialect.PostgreSQLDialect");
	// // // configOverrides.put("hibernate.hbm2ddl.auto", "create-drop");
	// // configOverrides.put("hibernate.show_sql", "false");
	// // configOverrides.put("hibernate.format_sql", "true");
	//
	// Properties prop = new Properties();
	// prop.put("javax.persistence.provider",
	// "org.hibernate.ejb.HibernatePersistence");
	// prop.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
	// prop.put("hibernate.connection.username", "postgres");
	// prop.put("hibernate.connection.password", "admin");
	// prop.put("hibernate.connection.driver_class", "org.postgresql.Driver");
	// prop.put("hibernate.connection.url",
	// "jdbc:postgresql://localhost:5432/postgres");
	// prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	// prop.put("hibernate.show_sql", "false");
	// prop.put("hibernate.format_sql", "true");
	//
	// Ejb3Configuration cfg = new Ejb3Configuration();
	// cfg.addAnnotatedClass(Agencia.class);
	// cfg.addAnnotatedClass(Banco.class);
	// cfg.addAnnotatedClass(Cargo.class);
	// cfg.addAnnotatedClass(CentroCusto.class);
	// cfg.addAnnotatedClass(Colaborador.class);
	// cfg.addAnnotatedClass(ColaboradorAgenciaConta.class);
	// cfg.addAnnotatedClass(ColaboradorDependente.class);
	// cfg.addAnnotatedClass(ColaboradorDocumento.class);
	// cfg.addAnnotatedClass(ColaboradorEndereco.class);
	// cfg.addAnnotatedClass(ColaboradorHorario.class);
	// cfg.addAnnotatedClass(ColaboradorRelacao.class);
	// cfg.addAnnotatedClass(ColaboradorSituacao.class);
	// cfg.addAnnotatedClass(ColaboradorSituacaoLicenca.class);
	// cfg.addAnnotatedClass(Competencia.class);
	// cfg.addAnnotatedClass(Empresa.class);
	// cfg.addAnnotatedClass(EstadoCivil.class);
	// cfg.addAnnotatedClass(Filiacao.class);
	// cfg.addAnnotatedClass(GrauInstrucao.class);
	// cfg.addAnnotatedClass(Lotacao.class);
	// cfg.addAnnotatedClass(Moeda.class);
	// cfg.addAnnotatedClass(Nacionalidade.class);
	// cfg.addAnnotatedClass(PlanoCargo.class);
	// cfg.addAnnotatedClass(Profissao.class);
	// cfg.addAnnotatedClass(Provincia.class);
	// cfg.addAnnotatedClass(Setor.class);
	// cfg.addAnnotatedClass(TipoDocumento.class);
	// cfg.addAnnotatedClass(TipoHorario.class);
	// cfg.addAnnotatedClass(TipoLicenca.class);
	// cfg.addAnnotatedClass(User.class);
	// cfg.addProperties(prop);
	//
	// EntityManagerFactory emf = cfg.buildEntityManagerFactory();
	//
	// EntityManager em = emf.createEntityManager();
	//
	// Colaborador col = new Colaborador();
	// Cargo cargo = new Cargo();
	//
	// cargo = em.find(Cargo.class, 1);
	//
	// col = em.find(Colaborador.class, 1);
	//
	// col.setCargo(cargo);
	//
	// em.getTransaction().begin();
	// em.merge(col);
	// em.getTransaction().commit();
	// System.out.println(((Colaborador) em.find(Colaborador.class,
	// 1)).getCargo().getId());
	// em.close();
	//
	//
	// }

	public static void main(String[] args) {
		
		String nome = "DOUGLASNUNESXAVIERRAMOS";
		
		nome = nome.substring(0,nome.indexOf(" "));
		
		System.out.println(nome);
		
		
	}

}
