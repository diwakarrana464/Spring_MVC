package com.rana.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rana.javabeans.PatientCommand;
import com.rana.javabeans.PatientDTO;
import com.rana.service.PatientMgmtService;
import com.rana.validator.PatientCommandValidator;

@Controller
//@SessionAttributes("patCmd")
public class PatientOperationController {
	
	@Autowired
	private PatientMgmtService service;
	
	@Autowired
	private PatientCommandValidator validator;
	

	
	@ModelAttribute("patCmd")
	public PatientCommand getPatientCommand() {
		System.out.println("getPatientCommand invoked");
		return new PatientCommand();
	}
	
	@GetMapping("/corona.htm")
	public String showForm(@ModelAttribute("patCmd")   PatientCommand cmd) {
		return "patient_registration";
	}
	
	@PostMapping("/corona.htm")
	public String processForm(Map<String,Object> map, 
									@ModelAttribute("patCmd")  PatientCommand cmd,
									BindingResult br)
			 {
						if(validator.supports(PatientCommand.class)) {
						validator.validate(cmd, br);
								if(br.hasErrors())
					return "patient_registration";
						}
				
		//.................................................................................................................
					String result = null;
					PatientDTO dto = new PatientDTO();
					BeanUtils.copyProperties(cmd, dto);
					result = service.register(dto);
					map.put("resMsg", result);
					return "show_result";
			 }
}
