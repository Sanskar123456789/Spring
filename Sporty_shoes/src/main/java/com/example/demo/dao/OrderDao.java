package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.OrderPojo;


@Service
public class OrderDao {
	@Autowired
	Orderrepo obj;
	
	// Insert
	public OrderPojo insert(OrderPojo s) {
		return obj.save(s);
	}
	
	// Update
	public OrderPojo update(OrderPojo e) {
		OrderPojo s = obj.findById(e.getId()).orElse(null);
		s.setTotal(e.getTotal());
		return obj.save(s);
	}
	
	// Delete 
	public Boolean delete(int id) {
		obj.deleteById(id);
		return true;
	}
	
	// Get Orders
	
	public List<OrderPojo> getOrders(){
		return obj.findAll();
	}
	
	// get specific orders
	public OrderPojo getOrder(int id) {
		return obj.findById(id).orElse(null);
	}
}
