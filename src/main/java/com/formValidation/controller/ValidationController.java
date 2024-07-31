package com.formValidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.formValidation.Entity.LoginData;

import jakarta.validation.Valid;


@Controller
public class ValidationController {

	@GetMapping("/form")
	public String openForm( Model model) { 
		
		model.addAttribute("LoginData" , new LoginData());
		return "form";
	}
	
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("LoginData") LoginData logindata , BindingResult result) { 
		
		if(result.hasErrors()) { 
			System.out.println(result);
			return "form";

		}
		System.out.println(logindata);
		return "Success";
	}
}
