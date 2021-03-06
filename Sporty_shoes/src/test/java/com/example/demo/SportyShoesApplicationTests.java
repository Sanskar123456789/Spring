package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.UserPojo;


@SpringBootTest
class SportyShoesApplicationTests {
	@Autowired
	UserDao s;

	@Test
	public void test() {
		UserPojo obj = new UserPojo();
		obj.setAddress("delhi");
		obj.setAdmin(false);
		obj.setEmail("rak@123");
		obj.setName("Rakesh");
		obj.setPassword("123");
		obj.setPhone_no("12345");
		assertNotNull(s.insert(obj));
	}

}
