package com.careassistant.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ProfesionalSalud extends Usuario {

	@Column(nullable = false)
	private String especialidad;

	private String disponibilidad;
	
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
