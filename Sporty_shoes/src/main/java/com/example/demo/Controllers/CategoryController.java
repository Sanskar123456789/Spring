package com.example.demo.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CatDao;
import com.example.demo.pojo.CategoryPojo;

@Controller
public class CategoryController {
	
	@Autowired
	CatDao obj;
	
	// Admin Mapping -----------------------------------------------------------------------------
	@RequestMapping("/GetCategories")
	public ModelAndView getCat() {
		ModelAndView mv = new ModelAndView();
		List<CategoryPojo> c = obj.getCat();
		
		mv.addObject("Categories", c);
		mv.setViewName("/Admin/Categories.jsp");
		return mv;
	}
	
	@RequestMapping("/cat_new")
	public ModelAndView newCat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/Admin/Cat_new.jsp");
		return mv;
	}
	
	@RequestMapping("/new_category")
	public ModelAndView catSave(HttpServletResponse res , HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		CategoryPojo c = new CategoryPojo();
		c.setCat(req.getParameter("Name"));
		obj.insert(c);
		List<CategoryPojo> cc = obj.getCat();
		mv.addObject("Categories", cc);
		mv.setViewName("/Admin/Categories.jsp");
		return mv;
	}
	
	@RequestMapping("/edit_cat/{catid}")
	public ModelAndView editCat(@PathVariable("catid") int id) {
		ModelAndView mv = new ModelAndView();
		CategoryPojo c = obj.get(id);
		mv.addObject("Categories", c);
		mv.setViewName("/Admin/edit_cat.jsp");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/edit_category")
	public String edit(HttpServletRequest req, HttpServletResponse res) {
		CategoryPojo c = obj.get(Integer.parseInt(req.getParameter("Id")));
		c.setCat(req.getParameter("Name"));
		obj.update(c);
		return "done";
	}
	
	@ResponseBody
	@RequestMapping("/deleteCat/{id}")
	public String Delete(HttpServletRequest req, HttpServletResponse res,@PathVariable("id") int id) {
		boolean c = obj.delete(id);
		if(c) {			
			return "done";
		}else {
			return "not done";			
		}
	}
	
	// User Mapping --------------------------------------------------------------------

}
