package es.deusto.server.jdo;

public class Admin extends Usuario{
	
	public Admin(String email, String contrasenya, boolean admin) {
		super(email, contrasenya, admin);
		// TODO Auto-generated constructo stub
		admin=true;
		
	}
	
}

