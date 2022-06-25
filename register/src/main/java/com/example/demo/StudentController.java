package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@Autowired
	studrepo obj;
	RestTemplate temp = new RestTemplate();
	
	@ResponseBody
	@RequestMapping("/registerUser/{sname}/{semail}/{spassword}")
	public String register(HttpServletResponse res, HttpServletRequest req,@PathVariable("sname") String sname,@PathVariable("semail") String semail,@PathVariable("spassword") String spassword) {
		System.out.println("heloo you");
		Student stud = new Student();
		stud.setSname(sname);
		stud.setSemail(semail);
		stud.setSpassword(spassword);
		Student i = obj.save(stud);
		if(i!=null) {			
			return "done";
		}else {
			return "not done";
		}
	}
	
	
}
