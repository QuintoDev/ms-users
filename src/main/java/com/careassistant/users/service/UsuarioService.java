package com.careassistant.users.service;

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
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

	public Usuario registrarse(Usuario usuario) {
		logger.info("{} se ha registrado correctamente.", usuario.getNombre());
		usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
		return usuarioRepository.save(usuario);
	}

	public void iniciarSesion(Usuario usuario) {
		logger.info("{} ha iniciado sesión.", usuario.getNombre());
	}

	public void cerrarSesion(Usuario usuario) {
		logger.info("{} ha cerrado sesión.", usuario.getNombre());
	}
}
