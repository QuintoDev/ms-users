package com.careassistant.users.service;

import com.careassistant.users.model.Usuario;
import com.careassistant.users.repository.UsuarioRepository;
import com.careassistant.users.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JwtUtil jwtUtil;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public String login(String correo, String contraseña) {
		Usuario usuario = usuarioRepository.findByCorreo(correo)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		if (!passwordEncoder.matches(contraseña, usuario.getContraseña())) {
			throw new RuntimeException("Contraseña incorrecta");
		}

		return jwtUtil.generarToken(correo);
	}
}
