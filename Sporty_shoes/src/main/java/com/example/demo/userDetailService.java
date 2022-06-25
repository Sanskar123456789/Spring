package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserRepo;
import com.example.demo.pojo.UserPojo;

@Service
public class userDetailService implements UserDetailsService{
	@Autowired
	UserRepo obj;
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
		System.out.println("UserName ------->  "+s);
		UserPojo user =  obj.findbyname(s);
		System.out.println("UserName ------->  "+user);
		return new com.example.demo.UserDetails(user);
	}

}
