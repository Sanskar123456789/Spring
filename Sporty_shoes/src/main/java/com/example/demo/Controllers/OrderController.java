package com.example.demo.Controllers;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CatDao;
import com.example.demo.dao.OrderDao;
import com.example.demo.dao.ShoeDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.CategoryPojo;
import com.example.demo.pojo.OrderPojo;
import com.example.demo.pojo.ShoePojo;
import com.example.demo.pojo.UserPojo;

@Controller
public class OrderController {

	@Autowired
	OrderDao obj;
	@Autowired
	UserDao user;
	@Autowired 
	ShoeDao obj1;
	@Autowired
	CatDao cat;
	
	Logger log = Logger.getAnonymousLogger();
	// User -----------------------------------------------------------------------------------------
	@RequestMapping("/Shoes_list/order/{id}/{userid}")
	public ModelAndView Order(@PathVariable("id") int id ,@PathVariable("userid") int userid) {
		log.info("In order");
		ModelAndView mv = new ModelAndView();
		ShoePojo shoe = obj1.getShoe(id);
		mv.setViewName("/User/InitaiateOrder.jsp");
		
		log.info("User");
		mv.addObject("userid",userid);
		log.info("shoe order");
		mv.addObject("Shoe_details", shoe);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/Shoes_list/order/{shoe_id}/confirm_order")
	public String placeOrder(HttpServletRequest req,HttpServletResponse res ) {
		
		OrderPojo order = new OrderPojo();
		
		UserPojo loginedUser = user.getUser(Integer.parseInt(req.getParameter("userid")));		
		ShoePojo shoe = obj1.getShoe(Integer.parseInt(req.getParameter("shoeid")));
		
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		
		order.setDate(date);		
		order.setShoe_id(shoe);
		order.setQuan(Integer.parseInt(req.getParameter("quan")));
		order.setTotal(shoe.getPrice());
		order.setUser_id(loginedUser);
		
		int currShoeQuantity = shoe.getQuantity();
		int orderedQuantity = order.getQuan();
		int newquan = currShoeQuantity - orderedQuantity;
		if(newquan >= 0) {			
			shoe.setQuantity(newquan);
			shoe = obj1.update(shoe);
			obj.insert(order);
			return "Order Placed";
		}else {
			return "Insufficient Shoes";
		}
	}
	
//	@RequestMapping("/Shoes_list/order/{shoe_id}/confirm_order")
//	public ModelAndView confirm() {
//		ModelAndView mv = new ModelAndView();
//		
//		return mv;
//	}
	
	// ADMIN -----------------------------------------------------------------------------------------
	
	@RequestMapping("/allOrders")
	public ModelAndView allorders() {
		ModelAndView mv = new ModelAndView();
		List<OrderPojo> order = obj.getOrders();
		List<CategoryPojo> c = cat.getCat();
		mv.setViewName("/Admin/Orders.jsp");
		mv.addObject("Orders", order);
		mv.addObject("Category", c);
		return mv;
	}
	
}
