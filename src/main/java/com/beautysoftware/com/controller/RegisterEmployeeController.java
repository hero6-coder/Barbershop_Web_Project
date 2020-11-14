package com.beautysoftware.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegisterEmployeeController {

	@GetMapping("employee/new")
	public String registerEmployee() {
		 
	     return "pages/register-employee";
	 }
}
