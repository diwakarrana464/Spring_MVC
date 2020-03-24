package com.rana.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountriesHandler implements Handler {

	@Override
	public String handle(HttpServletRequest req, HttpServletResponse res)  throws Exception{
		Locale[] locales = Locale.getAvailableLocales();
		List<String> countriesList = new ArrayList<>();
		for(Locale l : locales)
			countriesList.add(l.getDisplayCountry());
		req.setAttribute("result", countriesList);
		return "disp_countries";
	}
}
