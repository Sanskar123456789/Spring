package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.OrderPojo;

public interface Orderrepo extends JpaRepository<OrderPojo, Integer>{

}
