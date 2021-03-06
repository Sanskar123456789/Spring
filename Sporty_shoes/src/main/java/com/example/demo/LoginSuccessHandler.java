package com.example.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	Logger log = Logger.getAnonymousLogger(); 

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDetails user =  (UserDetails) authentication.getPrincipal();
		// System.out.println(user.getUsername());
		// Collection<? extends GrantedAuthority> auth = user.getAuthorities();
		// auth.forEach(a -> System.out.println(a.getAuthority()));
		
		
		String url = request.getContextPath();
		log.info("USER  ===>" + user.hasrole());
		if(user.hasrole()=="ROLE_ADMIN") {
			url+="/AdminDashboard";
			log.info("ADMIN----------->"+url);
		}else {
			url+="/Shoes_list";
			log.info("USER----------->"+url);
			url+="/"+user.hasid();
		}
		
		
		response.sendRedirect(url);
		
		//super.onAuthenticationSuccess(request, response, authentication);
	}
	

}
