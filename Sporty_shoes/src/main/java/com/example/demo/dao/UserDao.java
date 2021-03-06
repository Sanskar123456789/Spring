package com.example.demo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.pojo.UserPojo;

@Service
public class UserDao {

	@Autowired
	UserRepo obj;
	
	//Insert User
	public UserPojo insert(UserPojo u) {
		return obj.save(u);
	}
	
	//Update User Details
	public UserPojo update(UserPojo e) {
		UserPojo ss = obj.findById(e.getId()).orElse(null);
		ss.setAddress(e.getAddress());
		ss.setAdmin(e.getAdmin());
		ss.setEmail(e.getEmail());
		ss.setName(e.getName());
		ss.setPhone_no(e.getPhone_no());
		return obj.save(ss);
	}
	
	// Update Password
	public UserPojo updatePasswword(UserPojo s) {
		UserPojo e = obj.findById(s.getId()).orElse(null);
		e.setPassword(s.getPassword());
		return obj.save(e);
	}
	
	//Delete User
	public boolean delete(int id) {
		obj.deleteById(id);
		return true;
	}
	
	//Get Users
	public List<UserPojo> getUsers(){
		return obj.findAll();
	}
	
	//Get specific User 
	public UserPojo getUser(int id){
		return obj.findbyid(id);
		
	}
}
