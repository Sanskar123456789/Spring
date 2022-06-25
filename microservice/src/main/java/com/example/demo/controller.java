package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.ModelAndViewContainer;

@Controller
public class controller {
	
	@RequestMapping("insert")
	public ModelAndViewContainer getData() {
		ModelAndViewContainer mv = new ModelAndViewContainer ();
		
		return mv;
	}

}
