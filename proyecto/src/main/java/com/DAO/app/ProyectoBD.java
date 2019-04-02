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
	
	@Override
	public void registrar(Usuario usuario) {
		// TODO Auto-generated method stub
		PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
		Transaction transaction = persistentManager.currentTransaction();

		try {
			transaction.begin();
			System.out.println("   * Guardando objeto: " + usuario.getNombre());
			persistentManager.makePersistent(usuario);
			// Fin de la transaccion
			transaction.commit();
			System.out.println(" -Datos guardados");

		} catch (Exception ex) {
			System.err.println("* Excepcion insertando datos en la BD: " + ex.getMessage());
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}

			if (persistentManager != null && !persistentManager.isClosed()) {
				persistentManager.close();
			}
		}
	}
	

	@Override
	public Usuario getUsuario(String email) {
		// TODO Auto-generated method stub
		PersistenceManager pm = persistentManagerFactory.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;
	    
		try {
			System.out.println ("   * Sacando usuario con email: " + mail);
			
	    	tx.begin();
	    	
	    	@SuppressWarnings("unchecked")
			Query<Usuario> query = pm.newQuery("SELECT FROM " +Usuario.class.getName()+" WHERE email == '"+email+"'");

	    	query.setUnique(true);
	    	usuario = (Usuario)query.execute();	 
			
		
	    	query.close();	    
 	    	tx.commit();
   	    
	     } catch (Exception ex) {
		   	System.out.println("   $ Error recuperando usuario: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		 }
				
	   		pm.close();
	     }

	    return usuario;
	}
	
	public void updateUsuario(Usuario usuario) {
		PersistenceManager pm = persistentManagerFactory.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(usuario);
			tx.commit();
		}catch(Exception ex) {
			System.out.println("  $ Error actualizando usuario: "+ ex.getMessage());
		}finally {
			if(tx != null && tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	public void borrarUsuario() {
	System.out.println(" Borrando usuario ");
	PersistenceManager pm = persistentManagerFactory.getPersistenceManager();
	Transaction tx = pm.currentTransaction();
	Usuario usuario = null;
	try {
		tx.begin();
		pm.flush();
		Query<Usuario> query1= pm.newQuery("DELETE FROM "+Usuario.class.getName()+" WHERE email == '"+email+"'");
		query.setUnique(true);
    	usuario = (Usuario)query.execute();	 
    	query.close();	    
	    	tx.commit();
	    
     } catch (Exception ex) {
	   	System.out.println("   $ Error eliminando usuario: " + ex.getMessage());
     } finally {
	   	if (tx != null && tx.isActive()) {
	   		tx.rollback();
	 }
			
   		pm.close();
     }
	}
	
