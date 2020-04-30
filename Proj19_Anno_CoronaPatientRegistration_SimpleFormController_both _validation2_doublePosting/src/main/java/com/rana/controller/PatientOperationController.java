package com.rana.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String showForm(@ModelAttribute("patCmd") PatientCommand cmd) {
		return "patient_registration";
	}
	// .................................................................................................................................................................................................

	/*@PostMapping("/corona.htm")
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
					return "redirect:/result.htm?resMsg="+result;
			 }//end of handler method
	*/
	// ...................this sollution is with
	// FlashAttribytes.........................
	/*@PostMapping("/corona.htm")
	public String processForm( RedirectAttributes model, 
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
					//map.put("resMsg", result);
					//...flash attributs are temporary visible to only first request...
		model.addFlashAttribute("resMsg", result);
		model.addFlashAttribute("sysDate", new Date());
					
					model.addFlashAttribute("resMsg", result);
					model.addFlashAttribute("sysDate", new Date());
					
					return "redirect:/result.htm";
			 }//end of handler method
	*/ // another handler method to handle double posting problem..........
	
	
	//last and best sollution...............
	@PostMapping("/corona.htm")
	public String processForm( HttpSession ses, 
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
					//map.put("resMsg", result);
					//...flash attributs are temporary visible to only first request...
		/*model.addFlashAttribute("resMsg", result);
		model.addFlashAttribute("sysDate", new Date());*/
					
					ses.setAttribute("resMsg", result);
					ses.setAttribute("sysDate", new Date());
					
					return "redirect:/result.htm";
			 }//end of handler method

	@GetMapping("/result.htm")
	public String showResultPage() {
		System.out.println("PatientOperationController.showResultPage()");
		return "show_result";
	}

}
