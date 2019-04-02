package es.deusto.server.jdo;

public class Voluntario extends Usuario {
	
	public Voluntario(String email, String contrasenya, boolean admin, String tarea) {
		super(email, contrasenya, admin);
		// TODO Auto-generated constructor stub
		admin=false;
	}

}
