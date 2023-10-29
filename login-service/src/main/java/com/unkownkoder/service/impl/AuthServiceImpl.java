package com.unkownkoder.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unkownkoder.dto.LoginDto;
import com.unkownkoder.dto.LoginResponseDto;
import com.unkownkoder.dto.UserDto;
import com.unkownkoder.model.User;
import com.unkownkoder.repository.UserRepository;
import com.unkownkoder.service.AuthService;
import com.unkownkoder.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userNewsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public LoginResponseDto signIn(LoginDto loginDto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
		System.out.println(authentication);
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String jwtToken = jwtService.generateToken(user);
		LoginResponseDto loginResponse = new LoginResponseDto();
		loginResponse.setEmail(loginDto.getEmail());
		loginResponse.setJwtToken(jwtToken);
		return loginResponse;
	}

	@KafkaListener(topics="registration-topic",groupId = "registration-group")
	public void signUp(String message) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper= new ObjectMapper();
		UserDto userDto = objectMapper.readValue(message, UserDto.class);
		User user = new User();
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		Set<String> roles=new HashSet<>();
		roles.add(userDto.getRole());
		user.setRole(roles);
		userNewsRepository.save(user);
		
	}

}
