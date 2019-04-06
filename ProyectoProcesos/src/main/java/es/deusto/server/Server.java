package es.deusto.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import javax.swing.JOptionPane;

import es.deusto.server.jdo.Usuario;

public class Server extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = 1L;
	private int cont = 0;
	private PersistenceManager pm=null;
	private Transaction tx=null;

	protected Server() throws RemoteException {
		super();
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}
	
	protected void finalize () throws Throwable {
		if (tx.isActive()) {
            tx.rollback();
        }
        pm.close();
	}

	
	
	public void registrarUsuario(String email, String password, boolean admin) {
		try
        {	
            tx.begin();
            System.out.println("Comprobando si ya existe el usuario");
			Usuario usuario = null;
			try {
				usuario = pm.getObjectById(Usuario.class, email);
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				System.out.println("Exception launched: " + jonfe.getMessage());
			}
			System.out.println("User: " + usuario.getEmail());
			if (usuario.getEmail() != null) {
				System.out.println("Usuario ya existe");
				JOptionPane.showMessageDialog(null, "Usuario ya existe");
				
			} else {
				System.out.println("Creating user: " + email);
				usuario = new Usuario(email, password, admin);
				pm.makePersistent(usuario);					 
				System.out.println("User created: " + email);
				JOptionPane.showMessageDialog(null, "Usuario creado para " + email);
			}
			tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
      
        }
		
		
	}

	
	@Override
	public Usuario comprobarUsuario(String email,String password) {
		// TODO Auto-generated method stub
		
		pm.getFetchPlan().setMaxFetchDepth(3);
		
		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;
	    
		try {
			
	    	tx.begin();
	    	
	    	@SuppressWarnings("unchecked")
			Query<Usuario> query = pm.newQuery("SELECT FROM " +Usuario.class.getName()+" WHERE email == '"+email+"' AND password= '" +password+"'");
	    	
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

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			
			IServer objServer = new Server();
			Naming.rebind(name, objServer);
			System.out.println("Server '" + name + "' active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			@SuppressWarnings("unused")
			String line  = stdin.readLine();
		} catch (Exception e) {
			System.err.println("Hello exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
