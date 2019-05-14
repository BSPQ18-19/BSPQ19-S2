package es.deusto.server.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario implements Serializable{
	
	@PrimaryKey
	private String email;
	private String contrasenya;
	private boolean admin;
	//private static final long serialVersionUID = 1L;
	
	//Constructores
	
	public Usuario(String email, String contrasenya, boolean admin) {
		super();
		this.email = email;
		this.contrasenya = contrasenya;
		this.admin = false;
	}
	
	//getters y setters Email

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//getters y setters Contrasenya

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	//getters y setters Admin

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
