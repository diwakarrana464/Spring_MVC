package com.rana.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;
@Service("wishSer")
public class WishServiceImple implements WishService {

	String msg;
	
	@Override
	public String wishMsg() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(cal.HOUR_OF_DAY);
		if(hour <=12)
			msg = "good morning";
		else if(hour <= 16)
			msg = " good Afternoon";
		else if (hour<=20)
			msg = "good evening";
		else 
			msg = " good night";
		return msg;
	}
}
