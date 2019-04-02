package es.deusto.server.jdo;

public class Usuario {
	
	private String email;
	private String contrasenya;
	private boolean admin;
	
	public Usuario(String email, String contrasenya, boolean admin) {
		super();
		this.email = email;
		this.contrasenya = contrasenya;
		this.admin = false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	

}
