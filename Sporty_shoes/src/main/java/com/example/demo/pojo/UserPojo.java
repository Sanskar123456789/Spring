package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public  class UserPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// User Details
	private String name;
	private String email;
	private String Address;
	private String Phone_no;
	
	//Security
	private String Password;
	
	//Admin Check
	
	private boolean isAdmin;
	
	public boolean getAdmin() {
		return isAdmin;
	}
	
}
