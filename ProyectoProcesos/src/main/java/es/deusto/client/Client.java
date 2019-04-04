package es.deusto.client;


import java.rmi.RemoteException;

import es.deusto.server.IServer;

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
	
	public void iniciarSesion(String email, String password) {
		try {
			server.comprobarUsuario(email, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}