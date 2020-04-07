package com.rana.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageGeneratorController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String msg = null;
		Date d = new Date();
		int h = d.getHours();
		if(h<12)
			msg = "good morning";
		else if(h<16)
			msg = "good after noon";
		else if(h<20)
			msg = "good evening";
		else 
			 msg = "good night";
		return  new ModelAndView("result", "resMsg", msg);
	}
}
