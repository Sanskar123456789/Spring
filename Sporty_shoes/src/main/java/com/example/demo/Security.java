package com.example.demo;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
//authentication
	@Autowired
	UserDetailsService users;
	
@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// chain of config
	auth.userDetailsService(users);
	}
@Bean
public PasswordEncoder getpassword() {
	
	//dont change the password
	return NoOpPasswordEncoder.getInstance();
}
	

//authorization
@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/newShoe").hasRole("ADMIN")
	.antMatchers("/getShoes").hasRole("ADMIN")
	.antMatchers("/edit/*").hasRole("ADMIN")
	.antMatchers("/edit_shoe").hasRole("ADMIN")
	.antMatchers("/deleteShoe/*").hasRole("ADMIN")
	.antMatchers("/user").hasRole("ADMIN")
	.antMatchers("/Shoes_list").hasRole("USER")
	.antMatchers("/order/*").hasAnyRole("ADMIN","USER")
	.antMatchers("/register").permitAll()
	.antMatchers("/").permitAll().and().formLogin().successHandler(shandler).failureHandler(fhandler);

}

	@Autowired
	private  LoginSuccessHandler shandler;
	
	@Autowired
	private LoginFailureHandler fhandler;

}


