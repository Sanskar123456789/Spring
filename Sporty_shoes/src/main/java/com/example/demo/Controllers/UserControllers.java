package com.example.demo.Controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.UserPojo;

@Controller
public class UserControllers {
	
	@Autowired
	UserDao obj;
	
	// ADMIN ----------------------------------------------------------------------------
	
	@RequestMapping("/AdminDashboard")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Admin/dashborad.jsp");
		return mv;
	}
	
	@RequestMapping("/Users")
	public ModelAndView users(){
		ModelAndView mv = new ModelAndView();
		List<UserPojo> users = obj.getUsers();
		mv.setViewName("/Admin/Users.jsp");
		mv.addObject("Users", users);
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView reg() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/User/Register.jsp");
		return mv;
	}
	
	@RequestMapping("/register_new")
	public ModelAndView reg_new(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		UserPojo user = new UserPojo();
		user.setAdmin(false);
		user.setName(req.getParameter("name"));
		user.setAddress(req.getParameter("Address"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("Password"));
		user.setPhone_no(req.getParameter("Phone_no"));
		
		user = obj.insert(user);
		
		if(user!=null) {
			String url = "/Shoes_list/"+user.getId();
			System.out.println("url----------------->  "+url);
		}else {
			mv.setViewName("/Error.html");
		}
		return mv;
	}

}
