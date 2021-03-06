package com.example.demo.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.demo.dao.ShoeDao;
import com.example.demo.pojo.CategoryPojo;
import com.example.demo.pojo.ShoePojo;


@Controller
public class ShoeController {

	
	@Autowired
	ShoeDao obj;
	@Autowired
	CatDao cat;
	
	Logger logger
    = LoggerFactory.getLogger(ShoeController.class);
	
	// ADMIN MAPPINGS --------------------------------------------------------------------------------------
	
	@RequestMapping("/newShoe")
	@ResponseBody
	public String newShoe(HttpServletRequest req, HttpServletResponse res) {
		ShoePojo shoe = new ShoePojo();
		CategoryPojo c = cat.get(Integer.parseInt(req.getParameter("cat_id"))); 
		shoe.setName(req.getParameter("Name"));
		shoe.setCat_id(c);
		shoe.setCompany(req.getParameter("Company"));
		shoe.setDescription(req.getParameter("Description"));
		shoe.setPrice(Integer.parseInt(req.getParameter("Price")));
		shoe.setQuantity(Integer.parseInt(req.getParameter("Quantity")));
		
		shoe = obj.insert(shoe);
		if(shoe!=null) {
			return "Shoe Added";
		}else {
			return "Unable to add Shoe";
		}
	}
	
	@RequestMapping("/getShoes")
	public ModelAndView get() {
		ModelAndView mv = new ModelAndView();
		List<ShoePojo> shoes = obj.getShoes();
		List<CategoryPojo> c = cat.getCat();
		mv.setViewName("/Admin/shoe.jsp");
		mv.addObject("shoes",shoes);
		mv.addObject("Categories",c);
		return mv;
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(HttpServletRequest req , HttpServletResponse res, @PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		ShoePojo shoe = obj.getShoe(id);
		List<CategoryPojo> c = cat.getCat();
		if(shoe!=null){
			mv.setViewName("/Admin/shoe_edit.jsp");
			mv.addObject("shoe",shoe);
			mv.addObject("Categories", c);
		}else {
			mv.setViewName("/Error.html");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("edit_shoe")
	public String edit_shoe(HttpServletRequest req, HttpServletResponse res) {
		ShoePojo shoe = new ShoePojo();
		CategoryPojo c = cat.get(Integer.parseInt(req.getParameter("cat_id")));
		
		shoe.setCat_id(c);
		shoe.setName(req.getParameter("Name"));
		shoe.setCompany(req.getParameter("Company"));
		shoe.setDescription(req.getParameter("Description"));
		shoe.setPrice(Integer.parseInt(req.getParameter("Price")));
		shoe.setQuantity(Integer.parseInt(req.getParameter("Quantity")));
		shoe.setId(Integer.parseInt(req.getParameter("Id")));
		System.out.println("--dasdasd--------------   " + req.getParameter("Id") );
		shoe = obj.update(shoe);
		if(shoe!=null) {
			return "Shoe Updated";
		}else {
			return "Unable to Update Shoe";
		}
		
	}

	@ResponseBody
	@RequestMapping("/deleteShoe/{id}")
	public String delete(HttpServletRequest req, HttpServletResponse res , @PathVariable("id") int id) {
		boolean a = obj.delete(id);
		
		if(a) {
			return "deleted";
		}else {
			return "Not deleted";
		}
	}
	
	@RequestMapping("/shoe_new")
	public ModelAndView new_shoe() {
		ModelAndView mv = new ModelAndView();
		List<CategoryPojo> c = cat.getCat();
		mv.setViewName("/Admin/shoe_new.jsp");
		mv.addObject("Categories", c);
		return mv;
	}
	
	// USER MAPPINGS --------------------------------------------------------------------------------------
	
	@RequestMapping("/")
	public ModelAndView redirect() {
		ModelAndView mv = new ModelAndView();
		List<ShoePojo> shoes = obj.getShoes();
		List<CategoryPojo> c = cat.getCat();
		mv.addObject("shoes",shoes);
		mv.addObject("Categories",c);
		mv.setViewName("/User/Shoe_list.jsp");
		return mv;
	}
	
	@RequestMapping("/shoes")
	public ModelAndView shoes() {
		ModelAndView mv = new ModelAndView();
		List<ShoePojo> shoes = obj.getShoes();
		List<CategoryPojo> c = cat.getCat();
		mv.addObject("shoes",shoes);
		mv.addObject("Categories",c);
		mv.setViewName("/User/Shoe_list.jsp");
		return mv;
	}
	
	@RequestMapping("/Shoes_list/{userId}")
	public ModelAndView get_list(@PathVariable("userId") int id) {
		ModelAndView mv = new ModelAndView();
		logger.info("in");
		List<ShoePojo> shoes = obj.getShoes();
		List<CategoryPojo> c = cat.getCat();
		if(shoes!=null) {			
			logger.info("not in error.html");
			logger.info("ID--->" + id);
			mv.setViewName("/User/Shoe_list.jsp");
			mv.addObject("shoes",shoes);
			mv.addObject("userid",id);
			mv.addObject("Categories",c);
		}else {
			logger.info("in error.html");
			mv.setViewName("/Error.html");
		}
		return mv;
	
	}
	
	
}


