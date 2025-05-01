package com.careassistant.users.service;

import com.careassistant.users.model.Administrador;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

	public void gestionarUsuarios(Administrador admin) {
		System.out.println(admin.getNombre() + " está gestionando los usuarios del sistema.");
	}

	public void gestionarPlataforma(Administrador admin) {
		System.out.println(admin.getNombre() + " está administrando la plataforma CareAssistant.");
	}
}
