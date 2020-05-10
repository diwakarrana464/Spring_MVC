package com.rana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rana.command.CoronaPatient;

@Controller
public class CoronaPatientController {
	
	@RequestMapping("/register.htm")
	public String doRegister(
			@ModelAttribute("patCmd") CoronaPatient cmd
			) {
		return "patient_register";
	}

}
