package com.careassistant.users.model;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	public Administrador() {
		super();
	}

	public Administrador(Long id, String nombre, String correo, String contraseña, String rol) {
		super(id, nombre, correo, contraseña, rol);
	}

	public void gestionarUsuarios() {
		System.out.println(getNombre() + " está gestionando los usuarios del sistema.");
	}

	public void gestionarPlataforma() {
		System.out.println(getNombre() + " está administrando la plataforma CareAssistant.");
	}
}
