package com.careassistant.users.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.careassistant.users.dto.LoginDTO;
import com.careassistant.users.dto.ProfesionalSaludDTO;
import com.careassistant.users.model.Usuario;
import com.careassistant.users.repository.ProfesionalSaludRepository;
import com.careassistant.users.repository.UsuarioRepository;
import com.careassistant.users.service.ProfesionalSaludService;
import com.careassistant.users.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final UsuarioRepository usuarioRepository;
	private final ProfesionalSaludService profesionalSaludService;

	public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository,
			ProfesionalSaludRepository profesionalSaludRepository, ProfesionalSaludService profesionalSaludService) {
		this.usuarioService = usuarioService;
		this.usuarioRepository = usuarioRepository;
		this.profesionalSaludService = profesionalSaludService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable UUID id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<?> obtenerUsuarios(@RequestParam(required = false) String especialidad,
			@RequestParam(required = false) String ciudad) {

		// Buscar por filtros: especialidad y ciudad
		if (especialidad != null && ciudad != null) {
			List<ProfesionalSaludDTO> resultados = profesionalSaludService.buscarPorFiltros(especialidad, ciudad);
			return ResponseEntity.ok(resultados);
		}

		// Obtener todos los usuarios
		List<Usuario> usuarios = usuarioRepository.findAll();
		return ResponseEntity.ok(usuarios);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable UUID id) {
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
	public ResponseEntity<Usuario> login(@RequestBody LoginDTO loginDTO) throws Exception {
		Usuario usuario = usuarioService.iniciarSesion(loginDTO.getCorreo(), loginDTO.getContraseña());
		return ResponseEntity.ok(usuario);
	}

}
