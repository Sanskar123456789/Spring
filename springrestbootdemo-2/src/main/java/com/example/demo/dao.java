package com.example.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dao {
	@Autowired
	repo obj;
	
	//insert 
	public pojo insert(pojo e) {
		return obj.save(e);
	}
	
	//update
	public pojo update(pojo e) {
		pojo ss = obj.findById(e.getId()).orElse(null);
		ss.setEmail(e.getEmail());
		ss.setName(e.getEmail());
		return obj.save(ss);
	}
	
	//get data of one
	public pojo get(int id) {
		return obj.findById(id).orElse(null);
	}
	
	//getAll data
	public List<pojo> getAll(){
		return obj.findAll();
	}
	
	//delete
	public boolean delete(int id) {
		obj.deleteById(id);
		return true;
	}
	
}
