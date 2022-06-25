package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
	@Autowired
	dao obj;
	@RequestMapping("add")
	public ModelAndView addData(HttpServletRequest req, HttpServletResponse res) {
			ModelAndView mv= new ModelAndView();
			String name = req.getParameter("name");
			String Email = req.getParameter("Email");
			pojo e = new pojo();
			e.setName(name);
			e.setEmail(Email);
			e = obj.insert(e);
			if(e!=null) {
				mv.setViewName("Status");
			}else {
				mv.setViewName("Error");
			}
			return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteData(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		int id =Integer.parseInt(req.getParameter("id"));
		boolean r = obj.delete(id);
		if(r) {
			mv.setViewName("Status");
		}else {
			mv.setViewName("Error");
		}
		return mv;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		String name = req.getParameter("name");
		String Email = req.getParameter("Email");
		pojo e = new pojo();
		e.setName(name);
		e.setEmail(Email);
		e = obj.update(e);
		if(e!=null) {
			mv.setViewName("Status");
		}else {
			mv.setViewName("Error");
		}
		return mv;
	}
	
	@RequestMapping("get")
	public ModelAndView getData(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		List<pojo> list = obj.getAll();
		if(list!=null) {
			mv.setViewName("display");
			mv.addObject("list", list);
		}else {
			mv.setViewName("Error");
		}
		return mv;
	}
}
