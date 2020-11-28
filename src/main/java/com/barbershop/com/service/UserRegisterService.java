package com.barbershop.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.com.model.UserRegisterModel;
import com.barbershop.com.repository.UserRegisterRepository;

@Service
public class UserRegisterService {

	@Autowired
	private UserRegisterRepository userRegisterRepository;

	public void saveUser(UserRegisterModel userRegisterModel) {

		userRegisterRepository.save(userRegisterModel);
	}

}
