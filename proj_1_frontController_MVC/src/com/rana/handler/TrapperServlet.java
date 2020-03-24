package com.rana.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rana.servlet.CountriesHandler;
import com.rana.servlet.Handler;
import com.rana.servlet.LanguageHandler;

@WebServlet("*.do")
public class TrapperServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		Handler h=null;
		String lvn = null;
		String target = null;
		RequestDispatcher rd = null;
		String path = null;
		// action Management .....delegate request to handler classes.......
		try {
			 path = req.getServletPath();
			if(path.equalsIgnoreCase("/langs.do"))
				h = new LanguageHandler();
			else if(path.equalsIgnoreCase("/countries.do"))
				h = new CountriesHandler();
		else {
			throw new IllegalArgumentException("invalid request arguments");
		}
			 lvn =h.handle(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//..............................................................................................
		//mapping lvn(logical view name) to physical view that is jsp name....
		try {
		if(lvn.equalsIgnoreCase("disp_lang"))
			target = "show_langs.jsp";
		else if(lvn.equalsIgnoreCase("disp_countries"))
			target = "show_countries.jsp";
		else
			throw new IllegalArgumentException("illegal lvn arguments..");
		rd = req.getRequestDispatcher(target);
		rd.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		pw.println("<h1 style=\"text-align: center; color: blue;\"><a href=\"index.html\" >home</a>");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}
