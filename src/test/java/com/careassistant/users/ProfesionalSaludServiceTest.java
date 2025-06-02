package com.careassistant.users;

import com.careassistant.users.model.ProfesionalSalud;
import com.careassistant.users.repository.UsuarioRepository;
import com.careassistant.users.service.ProfesionalSaludService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfesionalSaludServiceTest {

	@Autowired
	private ProfesionalSaludService profesionalSaludService;
	
	@Autowired
    private UsuarioRepository usuarioRepository;

	@Test
	void testRegistrarProfesional() throws Exception {

		usuarioRepository.findByCorreo("maria.gomez@care.co").ifPresent(usuarioRepository::delete);

		ProfesionalSalud profesional = new ProfesionalSalud();
		profesional.setNombre("María");
		profesional.setApellido("Gómez");
		profesional.setCorreo("maria.gomez@care.co");
		profesional.setContraseña("password123");
		profesional.setCiudad("Barranquilla");
		profesional.setEspecialidad("Geriatría");
		profesional.setDisponibilidad(Arrays.asList("Lunes", "Miércoles", "Viernes"));
		profesional.setPresentacion("Profesional con más de 10 años de experiencia en cuidado geriátrico.");

		ProfesionalSalud registrado = profesionalSaludService.registrar(profesional);

		assertNotNull(registrado);
		assertNotNull(registrado.getId());
		assertEquals("María", registrado.getNombre());
		assertEquals("PROFESIONAL_SALUD", registrado.getRol());

		assertNotEquals("password123", registrado.getContraseña());
		assertNotEquals("Profesional con más de 10 años de experiencia en cuidado geriátrico.",
				registrado.getPresentacion());
	}
}
