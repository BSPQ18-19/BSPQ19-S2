package com.DTO.app;

import java.io.Serializable;

public class AdminDTO extends UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;


	public AdminDTO(String email, String contrasenya, boolean admin) {
		super(email, contrasenya, admin);
		// TODO Auto-generated constructor stub
		admin=true;
	}



}
