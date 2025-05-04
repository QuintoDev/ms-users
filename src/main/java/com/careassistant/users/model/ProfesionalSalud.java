package com.careassistant.users.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@NotEmpty
	@NotBlank(message = "La presentación es obligatoria")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(columnDefinition = "TEXT")
	private String presentacion;

	public ProfesionalSalud() {
		super();
	}

	public ProfesionalSalud(Long id, String nombre, String correo, String contraseña, String rol, String especialidad,
			String disponibilidad, String presentacion) {
		super(id, nombre, correo, contraseña, rol);
		this.especialidad = especialidad;
		this.disponibilidad = disponibilidad;
		this.presentacion = presentacion;
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

	public void aceptarSolicitud() {
	}

	public void actualizarDisponibilidad() {
	}
}
