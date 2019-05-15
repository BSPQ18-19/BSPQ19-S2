package es.deusto.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import es.deusto.server.jdo.Carrera;
import es.deusto.server.jdo.Usuario;

public interface IServer extends Remote {
	
	public Usuario comprobarUsuario(String email, String password) throws RemoteException;
	public void registrarUsuario(String email, String password, boolean admin) throws RemoteException;
	public String sacarContra(String usuario) throws RemoteException;
	public void crearCarrear(String cod, String nombreC, String fecha, String lugar, double precio, double premio)  throws RemoteException;
	public ArrayList<Carrera> listaCarreras () throws RemoteException;
	public void borrarCarrera (String cod) throws RemoteException;
	public void incribirse(String cod, String email)throws RemoteException;
	public void borrarParticipante(String cod, String email)throws RemoteException;
	public void anyadirPatrocinador(String cod, String nombre, double contribucion) throws RemoteException;
	public void borrarPatrocinador(String cod, String nombre)throws RemoteException;
	public void cerrar()throws RemoteException;
}
