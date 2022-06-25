package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class add {
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		System.out.println("hello");
		int result=Integer.parseInt(req.getParameter("no1"))+Integer.parseInt(req.getParameter("no2"));
		mv.setViewName("display");
		mv.addObject("res", result);
		return mv; 
	}
}
