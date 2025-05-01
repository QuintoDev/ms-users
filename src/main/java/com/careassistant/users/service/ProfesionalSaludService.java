package com.careassistant.users.service;

import com.careassistant.users.model.ProfesionalSalud;
import org.springframework.stereotype.Service;

@Service
public class ProfesionalSaludService {

	public void aceptarSolicitud(ProfesionalSalud profesional) {
		System.out.println(profesional.getNombre() + " ha aceptado una solicitud de cita.");
	}

	public void actualizarDisponibilidad(ProfesionalSalud profesional) {
		System.out.println(profesional.getNombre() + " ha actualizado su disponibilidad.");
	}
}
