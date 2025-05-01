package com.careassistant.users.controller;

import com.careassistant.users.model.Usuario;
import com.careassistant.users.repository.UsuarioRepository;
import com.careassistant.users.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final UsuarioRepository usuarioRepository;

	public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
		this.usuarioService = usuarioService;
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
	    Usuario guardado = usuarioService.registrarse(usuario);
	    return ResponseEntity.ok(guardado);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
	    List<Usuario> usuarios = usuarioRepository.findAll();
	    return ResponseEntity.ok(usuarios);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
	    Optional<Usuario> usuario = usuarioRepository.findById(id);
	    if (usuario.isPresent()) {
	        usuarioRepository.deleteById(id);
	        return ResponseEntity.noContent().build(); // 204 No Content
	    } else {
	        return ResponseEntity.notFound().build(); // 404 Not Found
	    }
	}


}
