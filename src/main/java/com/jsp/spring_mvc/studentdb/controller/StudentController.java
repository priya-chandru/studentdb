package com.jsp.spring_mvc.studentdb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	
	@RequestMapping(value = "/anything" ,method= RequestMethod.GET)
	public void print(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		req.setAttribute("namekey", name);
		req.setAttribute("ageKey", age);
		RequestDispatcher rd = req.getRequestDispatcher("output.jsp");
		rd.forward(req, resp);
	}
	
	@RequestMapping(value = "/anything2" ,method= RequestMethod.GET)
	public ModelAndView print2( String name,int age) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("nameKey", name);
		mav.addObject("ageKey", age);
		
		return mav;	
	}
	
}
