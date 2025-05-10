package com.careassistant.users.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Paciente extends Usuario {

	private Integer edad;

	private String parentesco;

	@NotBlank(message = "La ciudad es obligatoria")
	private String ciudad;

	private Integer celular;

	public Paciente() {
		super();
	}

	public Paciente(UUID id, String nombre, String apellido, String correo, String contraseña, String rol, Integer edad,
			String parentesco, String ciudad, Integer celular) {
		super(id, nombre, apellido, correo, contraseña, rol);
		this.edad = edad;
		this.ciudad = ciudad;
		this.celular = celular;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

}
