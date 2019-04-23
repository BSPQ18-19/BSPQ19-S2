package es.deusto.testing.junit;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Test;

import es.deusto.server.IServer;
import es.deusto.server.jdo.Usuario;

public class ServerTest {
	static IServer server;
	private PersistenceManagerFactory pmf=null;
	@Test
	public void testComprobarUsuario() {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Usuario usuario = new Usuario("prueba", "prueba", false);
		

			
		
		usuario = pm.getObjectById(Usuario.class, "prueba");
		usuario.getContrasenya().equals("prueba");
		
		Usuario usuario1 = new Usuario("prueba", "prueba", false);

	     
	
	   	assertEquals(usuario, usuario1);
	   		
		}

	 
	

}
