package com.unkownkoder.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
	public String extractUserName(String token);
	public String generateToken(UserDetails userDetails);
	public boolean isTokenValid(String token, UserDetails userDetails);
}
