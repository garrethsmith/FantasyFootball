package com.fantasy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static final SessionFactory factory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			return configuration.buildSessionFactory();

		} catch (Throwable e) {
			System.out.println("Hibernated exception caught building configuration " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public Session getSession () {
		return HibernateSessionFactory.getFactory().openSession();
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}
