package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.ShoePojo;


@Service
public class ShoeDao {
	
	
	@Autowired
	Shoerepo obj;
	
	// Insert
	public ShoePojo insert(ShoePojo s) {
		if(obj==null)
		System.out.println("==========================" + s);
		
		return obj.save(s);
	}
	
	// Update
	public ShoePojo update(ShoePojo e) {
		System.out.println("------------------------------"+e);
		ShoePojo s = obj.findById(e.getId()).orElse(null);
		System.out.println("------------------------------"+s);
		s.setCompany(e.getCompany());
		s.setDescription(e.getDescription());
		s.setName(e.getName());
		s.setPrice(e.getPrice());
		s.setQuantity(e.getQuantity());
		s.setCat_id(e.getCat_id());
		return obj.save(s);
	}
	
	// Delete 
	public Boolean delete(int id) {
		obj.deleteById(id);
		return true;
	}
	
	// Get Shoes
	
	public List<ShoePojo> getShoes(){
		return obj.findAll();
	}
	
	// get specific shoe
	public ShoePojo getShoe(int id) {
		return obj.findById(id).orElse(null);
	}
}
