package com.unkownkoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unkownkoder.dto.LoginDto;
import com.unkownkoder.dto.LoginResponseDto;
import com.unkownkoder.service.AuthService;


@RestController
@CrossOrigin()
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		LoginResponseDto loginResponseDto = authService.signIn(loginDto);
		return ResponseEntity.ok(loginResponseDto);
	}

}
