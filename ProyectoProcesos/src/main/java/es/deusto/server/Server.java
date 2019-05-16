package es.deusto.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;
import javax.swing.JOptionPane;

import es.deusto.server.jdo.Carrera;
import es.deusto.server.jdo.Patrocinadores;
import es.deusto.server.jdo.Usuario;

public class Server extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = 1L;
	private int cont = 0;
	private PersistenceManagerFactory pmf = null;
	PersistenceManager pm = null;

	protected Server() throws RemoteException {
		super();
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		pm = pmf.getPersistenceManager();

	}

	/*
	 * Registra Usuario en la BD
	 * 
	 * @see es.deusto.server.IServer#registrarUsuario(java.lang.String,
	 * java.lang.String, boolean)
	 */
	public void registrarUsuario(String email, String password, boolean admin) {

		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			System.out.println("Creating user: " + email);
			Usuario usuario = new Usuario(email, password, admin);
			pm.makePersistent(usuario);
			System.out.println("User created: " + email);
			JOptionPane.showMessageDialog(null, "Usuario creado para " + email);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

		}

	}

	/*
	 * Metodo de login
	 * 
	 * @see es.deusto.server.IServer#comprobarUsuario(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Usuario comprobarUsuario(String email, String password) {
		// TODO Auto-generated method stub

		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;

		try {

			try {
				usuario = pm.getObjectById(Usuario.class, email);
				if (usuario.getContrasenya().equals(password)) {
					return usuario;
				} else {
					usuario = null;
				}
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				System.out.println("Exception launched: " + jonfe.getMessage());
			}
			tx.begin();

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error recuperando usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

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
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(System.in);
			java.io.BufferedReader stdin = new java.io.BufferedReader(inputStreamReader);
			@SuppressWarnings("unused")
			String line = stdin.readLine();
		} catch (Exception e) {
			System.err.println("Hello exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * Saca la contrasenya para mandar por correo
	 * 
	 * @see es.deusto.server.IServer#sacarContra(java.lang.String)
	 */
	@Override
	public String sacarContra(String usuario) throws RemoteException {
		// TODO Auto-generated method stub

		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Usuario user = null;

		try {

			try {
				user = pm.getObjectById(Usuario.class, usuario);

			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				System.out.println("Exception launched: " + jonfe.getMessage());
			}
			tx.begin();

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error recuperando usuario: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}

		return user.getContrasenya();
	}

	/*
	 * Crea una nueva Carrera en la BD
	 * 
	 * @see es.deusto.server.IServer#crearCarrear(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, double, double)
	 */
	public void crearCarrear(String cod, String nombreC, String fecha, String lugar, double precio, double premio)
			throws RemoteException {

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			System.out.println("Creating race: " + cod);
			Carrera carrera = new Carrera(cod, nombreC, fecha, lugar, precio, premio);
			pm.makePersistent(carrera);
			System.out.println("User race: " + cod);
			JOptionPane.showMessageDialog(null, "Carreara creada para: " + cod + ", " + nombreC + ", " + lugar);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

		}
	}

	/*
	 * Saca Carreras activas
	 * 
	 * @see es.deusto.server.IServer#listaCarreras()
	 */
	public ArrayList<Carrera> listaCarreras() throws RemoteException {

		System.out.println("Sacando carreras de la BD");
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();

		ArrayList<Carrera> listaCarreras = new ArrayList<>();

		try {

			tx.begin();

			Extent<Carrera> ext = pm.getExtent(Carrera.class);

			Iterator<Carrera> iter = ext.iterator();

			while (iter.hasNext()) {
				Object obj = iter.next();
				Carrera c = (Carrera) obj;
				listaCarreras.add(c);
				System.out.println("carrera: " + c.getNombreC());
			}

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}
		System.out.println(listaCarreras.size());
		return listaCarreras;
	}

	/*
	 * Borra carrera de la BD
	 * 
	 * @see es.deusto.server.IServer#borrarCarrera(java.lang.String)
	 */
	public void borrarCarrera(String cod) throws RemoteException {

		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();

		tx.begin();

		@SuppressWarnings("unchecked")
		Query<Carrera> query = pm.newQuery("SELECT FROM " + Carrera.class.getName() + " WHERE cod == '" + cod + "' ");

		long numberdeleted = query.deletePersistentAll();

		System.out.println(numberdeleted + "users deleted");
		JOptionPane.showMessageDialog(null, "Carreara borrada " + cod);
		tx.commit();

	}

	@Override
	public void incribirse(String cod, String email) throws RemoteException {
		// TODO Auto-generated method stub

		Transaction tx = pm.currentTransaction();
		try {

			tx.begin();

			Usuario usuario = pm.getObjectById(Usuario.class, email);

			Extent<Carrera> ext = pm.getExtent(Carrera.class);

			Iterator<Carrera> iter = ext.iterator();

			while (iter.hasNext()) {
				Object obj = iter.next();
				Carrera c = (Carrera) obj;
				if (c.getCod().equals(cod)) {
					c.anyadirParticipante(usuario);
					System.out.println("carrera: " + c.getNombreC());
				}

			}
			JOptionPane.showMessageDialog(null, "Te has inscrito correctamente en la carrera");

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}

	}

	@Override
	public void borrarParticipante(String cod, String email) throws RemoteException {
		// TODO Auto-generated method stub

		Transaction tx = pm.currentTransaction();

		tx.begin();

		@SuppressWarnings("unchecked")
		Query<Carrera> query = pm.newQuery(
				"SELECT FROM carrera_listausuarios WHERE COD_OID == '" + email + "' AND EMAIL_EID == '" + cod + "' ");

		long numberdeleted = query.deletePersistentAll();

		System.out.println(numberdeleted + "Participante borrado");
		JOptionPane.showMessageDialog(null, "Participante borrado" );
		tx.commit();
	}

	@Override
	public void anyadirPatrocinador(String cod, String nombre, double contribucion) throws RemoteException {
		// TODO Auto-generated method stub

		Transaction tx = pm.currentTransaction();

		tx.begin();

		Patrocinadores p = new Patrocinadores(Patrocinadores.codigos, nombre, contribucion);

		pm.makePersistent(p);

		try {

			Extent<Carrera> ext = pm.getExtent(Carrera.class);

			Iterator<Carrera> iter = ext.iterator();

			while (iter.hasNext()) {
				Object obj = iter.next();
				Carrera c = (Carrera) obj;
				if (c.getCod().equals(cod)) {
					c.setPatrocinadores(p);
					System.out.println("carrera: " + c.getNombreC());
				}
				JOptionPane.showMessageDialog(null, "Patrocinador añadido a carrera: " + c.getCod());
			}

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}
	}

	@Override
	public void borrarPatrocinador(String cod, String cod1) throws RemoteException {
		// TODO Auto-generated method stub

		Transaction tx = pm.currentTransaction();

		tx.begin();

		try {

			Extent<Carrera> ext = pm.getExtent(Carrera.class);

			Iterator<Carrera> iter = ext.iterator();

			while (iter.hasNext()) {
				Object obj = iter.next();
				Carrera c = (Carrera) obj;
				if (c.getCod().equals(cod1)) {
					c.setPatrocinadores(null);
					System.out.println("carrera: " + c.getNombreC());
				}
			}
			JOptionPane.showMessageDialog(null, "Patrocinador borrado");

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		}
	}

	public void cerrar() throws RemoteException {
		pm.close();
		pmf.close();
	}

	@Override
	public void crearPatrocinador(String cod, String nombre, double contribucion) throws RemoteException {
		// TODO Auto-generated method stub
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			System.out.println("Creating patrocinador: " + cod);
			Patrocinadores patrocinador = new Patrocinadores(cod, nombre, contribucion);
			pm.makePersistent(patrocinador);
			System.out.println("Patrocinador creado: " + nombre);
			JOptionPane.showMessageDialog(null, "Patrocinador creado: " + cod + " " + nombre);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}

		}
	}

}
