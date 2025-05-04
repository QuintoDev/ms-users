package com.careassistant.users.controller;

import com.careassistant.users.dto.LoginDTO;
import com.careassistant.users.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginRequest) {
		String token = authService.login(loginRequest.getCorreo(), loginRequest.getContraseña());
		return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
	}
}
