package com.unkownkoder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unkownkoder.model.User;
import com.unkownkoder.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User not found with email : "+username));
		UserDetailsImpl userDetailsImpl=new UserDetailsImpl();
		userDetailsImpl.setUsername(username);
		userDetailsImpl.setPassword(user.getPassword());
		userDetailsImpl.setRoles(user.getRole());
		return userDetailsImpl;
	}

}
