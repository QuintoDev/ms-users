package com.careassistant.users.service;

import com.careassistant.users.model.ProfesionalSalud;
import com.careassistant.users.repository.ProfesionalSaludRepository;
import com.careassistant.users.security.AES256Encryptor;

import java.util.List;

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

	public List<ProfesionalSalud> buscarPorFiltros(String especialidad, String ciudad) {
		return profesionalSaludRepository.buscarPorFiltros(especialidad, ciudad);
	}

}
