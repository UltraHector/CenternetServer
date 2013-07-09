package com.TroyEmpire.CenternetServer.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	// which should be the same as the persisten-unit name
	private static final String CENTERNET_SERVER_ENTITYMANAGER_NAME = "com.TroyEmpire.CenternetServer.jpa";

	private static EntityManagerFactory emf;

	static {
		try {
			// Create the EntityManagerFactory from standard (persistence.xml)
			// config file.
			emf = Persistence
					.createEntityManagerFactory(CENTERNET_SERVER_ENTITYMANAGER_NAME);

		} catch (Exception ex) {
			System.err.println("Initial EntityManagerFactory creation failed."
					+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
}