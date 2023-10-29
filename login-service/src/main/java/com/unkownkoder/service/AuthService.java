package com.unkownkoder.service;

import com.unkownkoder.dto.LoginDto;
import com.unkownkoder.dto.LoginResponseDto;

public interface AuthService {
	LoginResponseDto signIn(LoginDto loginDto);
}
