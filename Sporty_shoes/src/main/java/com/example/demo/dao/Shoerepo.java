package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.ShoePojo;

public interface Shoerepo extends JpaRepository<ShoePojo, Integer>{
	
}
