package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojo.CategoryPojo;

public interface CatRepo extends JpaRepository<CategoryPojo, Integer>{
	@Query("select user from CategoryPojo user where user.id = ?1")
	public CategoryPojo findbyid(int id);
}
