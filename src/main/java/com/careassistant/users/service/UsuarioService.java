package com.careassistant.users.service;

import com.careassistant.users.model.Usuario;
import com.careassistant.users.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

	public Usuario registrarse(Usuario usuario) {
		System.out.println(usuario.getNombre() + " se ha registrado correctamente.");
		return usuarioRepository.save(usuario);
	}

	public void iniciarSesion(Usuario usuario) {
		System.out.println(usuario.getNombre() + " ha iniciado sesión.");
	}

	public void cerrarSesion(Usuario usuario) {
		System.out.println(usuario.getNombre() + " ha cerrado sesión.");
	}
}
