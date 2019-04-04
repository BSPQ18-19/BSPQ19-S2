package es.deusto.server.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable = "true")
public class Usuario implements Serializable{
	
	@PrimaryKey
	private String email;
	private String contrasenya;
	private boolean admin;
	private static final long serialVersionUID = 1L;
	
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
