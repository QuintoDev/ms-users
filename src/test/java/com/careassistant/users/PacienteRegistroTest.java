package com.careassistant.users;

import com.careassistant.users.model.Paciente;
import com.careassistant.users.repository.UsuarioRepository;
import com.careassistant.users.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PacienteRegistroTest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testRegistrarPaciente() throws Exception {

        usuarioRepository.findByCorreo("laura.perez@care.co")
                .ifPresent(usuarioRepository::delete);

        Paciente paciente = new Paciente();
        paciente.setNombre("Laura");
        paciente.setApellido("Pérez");
        paciente.setCorreo("laura.perez@care.co");
        paciente.setContraseña("mypassword");
        paciente.setCiudad("Bogotá");
        paciente.setEdad(65);
        paciente.setParentesco("Hija");
        paciente.setCelular(3201234567L);

        Paciente registrado = (Paciente) usuarioService.registrar(paciente);

        assertNotNull(registrado);
        assertNotNull(registrado.getId());
        assertEquals("Laura", registrado.getNombre());
        assertEquals("PACIENTE", registrado.getRol());
        assertEquals(65, registrado.getEdad());
        assertEquals("Bogotá", registrado.getCiudad());
        assertEquals("Hija", registrado.getParentesco());
        assertEquals(3201234567L, registrado.getCelular());
    }
}
