package com.careassistant.users.controller;

import com.careassistant.users.dto.LoginDTO;
import com.careassistant.users.model.Usuario;
import com.careassistant.users.repository.UsuarioRepository;
import com.careassistant.users.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
    @PostMapping
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario usuario) throws Exception {
        Usuario creado = usuarioService.registrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody LoginDTO login) throws Exception {
	    Usuario usuario = usuarioService.iniciarSesion(login.getCorreo(), login.getContraseña());
	    return ResponseEntity.ok(usuario);
	}

}
