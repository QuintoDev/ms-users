package com.careassistant.users.model;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	public Administrador() {
		super();
	}

	public Administrador(Long id, String nombre, String apellido, String correo, String contraseña, String rol) {
		super(id, nombre, apellido, correo, contraseña, rol);
	}

}
