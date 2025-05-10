package com.careassistant.users.model;

import java.util.UUID;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	public Administrador() {
		super();
	}

	public Administrador(UUID id, String nombre, String apellido, String correo, String contraseña, String rol) {
		super(id, nombre, apellido, correo, contraseña, rol);
	}

}
