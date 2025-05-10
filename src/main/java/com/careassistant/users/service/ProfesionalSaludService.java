package com.careassistant.users.service;

import com.careassistant.users.model.ProfesionalSalud;
import com.careassistant.users.repository.ProfesionalSaludRepository;
import com.careassistant.users.security.AES256Encryptor;
import com.careassistant.users.dto.ProfesionalSaludDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfesionalSaludService {

	private final ProfesionalSaludRepository profesionalSaludRepository;
	private final AES256Encryptor aes;
	private final PasswordEncoder passwordEncoder;
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	public ProfesionalSaludService(ProfesionalSaludRepository profesionalSaludRepository, AES256Encryptor aes,
			PasswordEncoder passwordEncoder) {
		super();
		this.profesionalSaludRepository = profesionalSaludRepository;
		this.aes = aes;
		this.passwordEncoder = passwordEncoder;
	}

	public ProfesionalSalud registrar(ProfesionalSalud profesional) throws Exception {
		String cifrado = aes.encrypt(profesional.getPresentacion());
		profesional.setPresentacion(cifrado);
		profesional.setRol("PROFESIONAL_SALUD");
		profesional.setContraseña(passwordEncoder.encode(profesional.getContraseña()));
		logger.info("{} se ha registrado correctamente.", profesional.getNombre());
		return profesionalSaludRepository.save(profesional);
	}

	public void aceptarSolicitud(ProfesionalSalud profesional) {
		System.out.println(profesional.getNombre() + " ha aceptado una solicitud de cita.");
	}

	public void actualizarDisponibilidad(ProfesionalSalud profesional) {
		System.out.println(profesional.getNombre() + " ha actualizado su disponibilidad.");
	}

	public List<ProfesionalSaludDTO> buscarPorFiltros(String especialidad, String ciudad) {
		List<ProfesionalSalud> profesionales = profesionalSaludRepository.buscarPorFiltros(especialidad, ciudad);

		return profesionales.stream().map(p -> {
			ProfesionalSaludDTO dto = new ProfesionalSaludDTO();
			dto.setId(p.getId());
			dto.setNombre(p.getNombre());
			dto.setApellido(p.getApellido());
			dto.setEspecialidad(p.getEspecialidad());
			dto.setCiudad(p.getCiudad());
			dto.setCorreo(p.getCorreo());
			dto.setDisponibilidad(p.getDisponibilidad());
			dto.setRol(p.getRol());
			try {
				dto.setPresentacion(aes.decrypt(p.getPresentacion()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}).collect(Collectors.toList());
	}

}
