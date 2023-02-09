package com.demo.studentcrud.service;

import com.demo.studentcrud.entity.Student;
import com.demo.studentcrud.response.StudentResponse;

public interface StudentService {

	public StudentResponse getAllStudents();

	public StudentResponse getStudentById(int id);

	public StudentResponse saveStudent(Student student);

	public StudentResponse updateStudent(int id, Student student);

	public StudentResponse deleteStudent(int id);

}
