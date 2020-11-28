package com.barbershop.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.barbershop.com.model.UserRegisterModel;
import com.barbershop.com.repository.UserRegisterRepository;

@Service
public class ImplementUserDetailService implements UserDetailsService {

	@Autowired
	UserRegisterRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserRegisterModel user = repository.findUserByLogin(username);
		
		if(user == null) {
			
			throw new UsernameNotFoundException("user not found ");
		}
		return user;
	}

	
}
