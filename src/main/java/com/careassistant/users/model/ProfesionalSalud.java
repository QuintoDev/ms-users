package com.careassistant.users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ProfesionalSalud extends Usuario {

	@Column(nullable = false)
	private String especialidad;

	private String disponibilidad;

	public ProfesionalSalud() {
		super();
	}

	public ProfesionalSalud(Long id, String nombre, String correo, String contraseña, String rol, String especialidad,
			String disponibilidad) {
		super(id, nombre, correo, contraseña, rol);
		this.especialidad = especialidad;
		this.disponibilidad = disponibilidad;
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

	public void aceptarSolicitud() {
		System.out.println(getNombre() + " ha aceptado una solicitud de cita.");
	}

	public void actualizarDisponibilidad() {
		System.out.println(getNombre() + " ha actualizado su disponibilidad.");
	}
}
