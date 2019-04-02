package com.data.app;

public class Usuario {
	private String nombre;
	private String email;
	private String contrasenya;
	private boolean admin;
	
	public Usuario(String nombre,String email, String contrasenya, boolean admin) {
		super();
		this.nombre=nombre;
		this.email = email;
		this.contrasenya = contrasenya;
		this.admin = false;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.email = nombre;
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
