package com.example.demo.pojo;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class OrderPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne()
	private ShoePojo Shoe_id;
	@OneToOne
	private UserPojo user_id;
	private Date date;
	private int quan;
	private int total;
}
