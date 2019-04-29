package es.deusto.client;


import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import es.deusto.server.IServer;
import es.deusto.server.jdo.Carrera;
import es.deusto.server.jdo.Usuario;

public class Client {
	static IServer server;

	public Client() {
		VInicio vinicio=new VInicio(this);
		vinicio.setVisible(true);
	}
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			//Descomentar cuando el servidor funcione!!
			server = (IServer) java.rmi.Naming.lookup(name);	
			// Register to be allowed to send messages
			//objHello.registerUser("dipina", "dipina", false);
			new Client();
			
			
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Usuario iniciarSesion(String email, String password) {
		Usuario user=null;
		try {
			user=server.comprobarUsuario(email, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void registrarUsuario(String email, String password) {
		try {
			
			server.registrarUsuario(email, password, false);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String sacarContra(String email) {
		try {
			
			return server.sacarContra(email);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void crearCarrear(String cod, String nombreC, String fecha, String lugar, double precio, double premio) {
		try {	
			server.crearCarrear(cod, nombreC, fecha, lugar, precio, premio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public ArrayList<Carrera> listaCarreras (){
		
		try {	
			return server.listaCarreras();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	public void borrarCarrera (String cod) {
		try {
			server.borrarCarrera(cod);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
