package com.DAO.app;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class ProyectoBD {

	private PersistenceManagerFactory persistentManagerFactory;

	public ProyectoBD() {
		persistentManagerFactory = JDOHelper
				.getPersistenceManagerFactory("datanucleus.properties");
	}
	
}
