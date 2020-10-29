package com.beautysoftware.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegisterClienteController {

	@GetMapping("client/new")
	public String registerNewClient() {
		
		return "/pages/register-client";
	}
}
