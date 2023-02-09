package com.demo.studentcrud.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.studentcrud.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	public Optional<Student> findByEmail(String email);
	
}
