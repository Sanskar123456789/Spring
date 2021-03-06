package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface studrepo extends JpaRepository<Student, Integer> {
	@Query("select student from Student student where student.sname=?1")
	public Student findByname(String name);

}