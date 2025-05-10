package com.careassistant.users.service;

import com.careassistant.users.model.ProfesionalSalud;
import com.careassistant.users.model.Usuario;
import com.careassistant.users.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final ProfesionalSaludService profesionalSaludService;
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
			ProfesionalSaludService profesionalSaludService) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
		this.profesionalSaludService = profesionalSaludService;
	}

	public Usuario registrar(Usuario usuario) throws Exception {
		if (usuario instanceof ProfesionalSalud profesional) {
			return profesionalSaludService.registrar(profesional);
		}
		usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
		usuario.setRol("PACIENTE");
		logger.info("{} se ha registrado correctamente.", usuario.getNombre());
		return usuarioRepository.save(usuario);
	}

	public Usuario iniciarSesion(String correo, String contraseña) throws Exception {
		Usuario usuario = usuarioRepository.findByCorreo(correo)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		if (!passwordEncoder.matches(contraseña, usuario.getContraseña())) {
			logger.info("Contraseña incorrecta");
			throw new RuntimeException("Contraseña incorrecta");
		} else {
			logger.info("El {} {} ha iniciado sesion correctamente.", usuario.getRol(), usuario.getNombre());
			return usuario;
		}

	}

	public void cerrarSesion(Usuario usuario) {
		logger.info("{} ha cerrado sesión.", usuario.getNombre());
	}
}
