package com.demo.studentcrud.entity;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private String email;
	private String branch;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getBranch() {
//		return branch;
//	}
//
//	public void setBranch(String branch) {
//		this.branch = branch;
//	}
//
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", branch=" + branch
//				+ "]";
//	}
	
	

}
