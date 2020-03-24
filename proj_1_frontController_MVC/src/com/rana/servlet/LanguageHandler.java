package com.rana.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageHandler implements Handler {

	@Override
	public String handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//by factory of locale  we will get all locale.
		Locale[] locales = Locale.getAvailableLocales();
		List<String> langList = new ArrayList<String>();
		for(Locale l : locales) 
				langList.add(l.getDisplayLanguage());
		req.setAttribute("result", langList);
		return "disp_lang";
	}
}
