package com.rana.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rana.service.WishService;

@Controller
public class ShowHomeController {
	
	@Resource
	private WishService service;
	
	@RequestMapping("/home.htm")
	public String home() {
		return "welcome";
	}
	
	@RequestMapping("/wish.htm")
	public ModelAndView wish() {
		String msg = service.wishMsg();
		return new ModelAndView("result", "wmsg", msg);
	}

}
