package com.careassistant.users.service;

import com.careassistant.users.model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

	public void buscarProfesional(Paciente paciente) {
		System.out.println(paciente.getNombre() + " está buscando un profesional de salud...");
	}

	public void solicitarServicio(Paciente paciente) {
		System.out.println(paciente.getNombre() + " ha solicitado un servicio médico a domicilio.");
	}
}
