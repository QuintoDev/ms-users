package com.careassistant.users.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Paciente extends Usuario {

	private Integer edad;

	@NotBlank(message = "La ciudad es obligatoria")
	private String ciudad;

	public Paciente() {
		super();
	}

	public Paciente(UUID id, String nombre, String apellido, String correo, String contraseña, String rol, Integer edad, String ciudad) {
		super(id, nombre, apellido, correo, contraseña, rol);
		this.edad = edad;
		this.ciudad = ciudad;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
