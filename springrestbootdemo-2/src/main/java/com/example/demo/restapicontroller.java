package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restapicontroller {

	@Autowired
	repo obj;
	
	@PostMapping("/insert")
	public pojo einsert(@RequestBody pojo e) {
		return obj.save(e);
	}
	
	@GetMapping("/get")
	public List<pojo> getAll(){
		return obj.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		obj.deleteById(id);
		return "Deleted";
	}
}
