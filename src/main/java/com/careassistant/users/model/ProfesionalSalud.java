package com.careassistant.users.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ProfesionalSalud extends Usuario {

	@NotBlank(message = "La especialidad es obligatoria")
	@Column(nullable = false)
	private String especialidad;

	private String disponibilidad;

	@NotBlank(message = "La ciudad es obligatoria")
	private String ciudad;

	@NotEmpty
	@NotBlank(message = "La presentación es obligatoria")
	@Column(columnDefinition = "TEXT")
	private String presentacion;

	public ProfesionalSalud() {
		super();
	}

	public ProfesionalSalud(UUID id, String nombre, String apellido, String correo, String contraseña, String rol, String especialidad,
			String disponibilidad, String presentacion, String ciudad) {
		super(id, nombre, apellido, correo, contraseña, rol);
		this.especialidad = especialidad;
		this.disponibilidad = disponibilidad;
		this.presentacion = presentacion;
		this.ciudad = ciudad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void actualizarDisponibilidad() {
	}
}
