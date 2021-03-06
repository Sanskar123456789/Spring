package com.example.demo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.pojo.CategoryPojo;

@Service
public class CatDao {
	
	@Autowired
	CatRepo obj;
	
	// insert 
	public CategoryPojo insert(CategoryPojo c) {
		return obj.save(c);
	}
	
	// update
	public CategoryPojo update(CategoryPojo c) {
		CategoryPojo cat = obj.findById(c.getId()).orElse(null);
		cat.setCat(c.getCat());
		return obj.save(cat);
	}
	
	// delete
	public boolean delete(int id) {
		obj.deleteById(id);
		return true;
	}
	
	//get
	public List<CategoryPojo> getCat(){
		return obj.findAll();
	}
	
	//get by id
	public CategoryPojo get(int id) {
		return obj.findbyid(id);
	}
}
