package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojo.UserPojo;

public interface UserRepo extends JpaRepository<UserPojo,Integer > {
	
	@Query("select user from UserPojo user where user.name = ?1")
	public UserPojo findbyname(String s);
	
	@Query("select user from UserPojo user where user.id = ?1")
	public UserPojo findbyid(int id);
}
