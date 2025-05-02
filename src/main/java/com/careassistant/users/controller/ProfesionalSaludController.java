package com.careassistant.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careassistant.users.model.ProfesionalSalud;
import com.careassistant.users.service.ProfesionalSaludService;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalSaludController {

    private final ProfesionalSaludService profesionalService;

    public ProfesionalSaludController(ProfesionalSaludService profesionalService) {
        this.profesionalService = profesionalService;
    }

    @PostMapping
    public ResponseEntity<ProfesionalSalud> registrar(@RequestBody ProfesionalSalud profesional) throws Exception {
        ProfesionalSalud creado = profesionalService.registrar(profesional);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
