package com.careassistant.users.model;

import jakarta.persistence.Entity;

@Entity
public class Paciente extends Usuario {

	public Paciente() {
		super();
	}

	public Paciente(Long id, String nombre, String correo, String contraseña, String rol) {
		super(id, nombre, correo, contraseña, rol);
	}

	public void buscarProfesional() {
		System.out.println(getNombre() + " está buscando un profesional de salud...");
	}

	public void solicitarServicio() {
		System.out.println(getNombre() + " ha solicitado un servicio médico a domicilio.");
	}
}
