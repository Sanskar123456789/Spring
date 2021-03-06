package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@Autowired
	studrepo obj;
	RestTemplate temp = new RestTemplate();
	@ResponseBody
	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("hello");
		ModelAndView mv = new ModelAndView();
		String suser = req.getParameter("suser");
		String Password = req.getParameter("spassword");
		Student data = obj.findByname(suser);
		System.out.println(data.toString() + Password);
		if(data.getSpassword().equals(Password)) {
			HttpSession session = req.getSession();
			session.setAttribute("suser", suser);
			mv.setViewName("display"); 
			return "Logged in";
		}else {
			return "Credentials not matched"; 
		}
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public String register(HttpServletResponse res, HttpServletRequest req) {
		String sname = req.getParameter("sname");
		String semail = req.getParameter("semail");
		String spassword = req.getParameter("spassword");
		String link= "http://localhost:8081/registerUser/"+sname+"/"+semail+"/"+spassword;
		temp.getForObject(link, String.class);
		return "done";
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "LogOut Success"; 

	}
}
