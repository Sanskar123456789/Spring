package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.example.demo.pojo.UserPojo;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
	
	private String username;
	private String pass;
	private String auth;
	private int id;
	Logger log = Logger.getAnonymousLogger();
	public UserDetails(UserPojo user) {
		this.username = user.getName();
		this.pass = user.getPassword();
		this.id = user.getId();
		if(user.getAdmin()) {
			log.info("ADMIN " +user.getAdmin());
			this.auth = "ROLE_ADMIN";
		}else {
			log.info("USER " +user.getAdmin());
			this.auth = "ROLE_USER";
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority(this.auth));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String hasrole() {
		return auth;
	}
	
	public int hasid() {
		return id;
	}

}
