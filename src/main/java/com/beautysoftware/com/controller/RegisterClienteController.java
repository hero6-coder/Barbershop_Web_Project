package com.beautysoftware.com.controller;

import com.beautysoftware.com.modelDto.RegisterClientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class RegisterClienteController {

	@GetMapping("client/new")
	public String registerNewClient(Model model) {
		
		return "pages/register-client";
	}

	@PostMapping("client/new")
	public String submitForm(@Valid @ModelAttribute("user") RegisterClientDto user,
							 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "pages/register-client";
		}
		//todo if register ok, then save user to repository
		//todo check email - send email
		// todo create user account
		return "pages/login";
	}
}
