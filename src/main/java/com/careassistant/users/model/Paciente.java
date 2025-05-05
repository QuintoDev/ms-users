package com.careassistant.users.model;

import jakarta.persistence.Entity;

@Entity
public class Paciente extends Usuario {
	
	private Integer edad;

	public Paciente() {
		super();
	}

	public Paciente(Long id, String nombre, String correo, String contraseña, String rol, Integer edad) {
		super(id, nombre, correo, contraseña, rol);
		this.edad = edad;
	}
	
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}
