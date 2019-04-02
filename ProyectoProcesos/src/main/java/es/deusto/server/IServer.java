package es.deusto.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.deusto.server.jdo.Usuario;

public interface IServer extends Remote {
	
	Usuario comprobarUsuario(String email, String password) throws RemoteException;
	void borrarUsuario(String usuario) throws RemoteException;
	void registrarUsuario(String email, String password, boolean admin) throws RemoteException;
	
}
