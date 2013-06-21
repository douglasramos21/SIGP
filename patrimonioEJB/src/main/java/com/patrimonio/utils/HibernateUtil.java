//package com.patrimonio.utils;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
//import com.consultorio.entity.Bem;
//import com.consultorio.entity.CategoriaBem;
//import com.consultorio.entity.MarcaBem;
//import com.consultorio.entity.ModeloBem;
//import com.consultorio.entity.TipoBem;
//import com.consultorio.entity.User;
//
//public class HibernateUtil {
//
//	private static SessionFactory factory;
//	private static ServiceRegistry registry;
//
//	private static SessionFactory configureSessionFactory() {
//
//		try {
//			Configuration cfg = new Configuration();
//			cfg.setProperty("connection.driver_class", "org.postgresql.Driver");
//			cfg.setProperty("connection.url", "jdbc:postgresql://localhost:5432/postgres");
//			cfg.setProperty("connection.username", "postgres");
//			cfg.setProperty("connection.password", "admin");
//			cfg.setProperty("hibernate.default_schema", "consultorio");
//			cfg.setProperty("hibernate.show_sql", "false");
//			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//			cfg.setProperty("hibernate.c3p0.min_size", "5");
//			cfg.setProperty("hibernate.c3p0.max_size", "20");
//			cfg.setProperty("hibernate.c3p0.timeout", "1800");
//			cfg.setProperty("hibernate.c3p0.max_statements", "50");
//			cfg.setProperty("hibernate.cache.use_second_level_cache", "false");
//			cfg.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
//			cfg.setProperty("hibernate.connection.pool_size", "10");
//			cfg.setProperty("hibernate.hbm2ddl.auto", "update");
//			
//			
//
//			// cfg.addAnnotatedClass(Clinica.class);
//			cfg.addAnnotatedClass(User.class);
//			cfg.addAnnotatedClass(Bem.class);
//			cfg.addAnnotatedClass(MarcaBem.class);
//			cfg.addAnnotatedClass(CategoriaBem.class);
//			cfg.addAnnotatedClass(ModeloBem.class);
//			cfg.addAnnotatedClass(TipoBem.class);
//
//			registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
//			factory = cfg.buildSessionFactory(registry);
//
//			return factory;
//
//		} catch (Throwable e) {
//			System.err.println("Failed to create sessionFactory object." + e);
//			throw new ExceptionInInitializerError(e);
//		}
//
//	}
//
//	public static SessionFactory getSessionFactory() {
//
//		return configureSessionFactory();
//
//	}
//
//}