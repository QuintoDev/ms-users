package com.careassistant.users.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careassistant.users.service.ProfesionalSaludService;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalSaludController {

    public ProfesionalSaludController(ProfesionalSaludService profesionalService) {
    }

}
