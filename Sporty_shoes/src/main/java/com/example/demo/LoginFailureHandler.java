package com.example.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;


@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler 
{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		getRedirectStrategy().sendRedirect(request, response, "/index.jsp");
	}
	
}
