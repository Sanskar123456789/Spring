package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ShoePojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	// Shoe Details
	private String name;
	private String company;
	private String description;
	private int price;
	private int quantity;
	
	@OneToOne
	private CategoryPojo cat_id;
}
