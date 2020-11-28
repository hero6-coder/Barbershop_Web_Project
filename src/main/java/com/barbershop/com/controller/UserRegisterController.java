package com.barbershop.com.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.barbershop.com.model.UserRegisterModel;
import com.barbershop.com.service.UserRegisterService;

@Controller
@RequestMapping("/")
public class UserRegisterController {

	@Autowired
	private UserRegisterService userRegisterService;

	@GetMapping("registerUser/new")
	public String registerNewUser(Model model) {

		model.addAttribute("user", new UserRegisterModel());
		return "pages/register-user";
	}

	@PostMapping(path = "registerUser/save")
	public String saveUser(@ModelAttribute("user") UserRegisterModel userRegisterModel,
			@RequestParam("file")MultipartFile file){

		     try {
				userRegisterModel.setPhoto(file.getBytes());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		     
		userRegisterService.saveUser(userRegisterModel);
		return "redirect:/registerUser/new";

	}

}
