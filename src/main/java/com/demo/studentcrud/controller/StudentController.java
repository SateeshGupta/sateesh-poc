package com.demo.studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.studentcrud.entity.Student;
import com.demo.studentcrud.response.StudentResponse;
import com.demo.studentcrud.service.StudentService;

@RestController
@RequestMapping("/std")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/findAll")
	public ResponseEntity<StudentResponse> getAllStudent() {
		StudentResponse allStudents = studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(allStudents);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<StudentResponse> getStudent(@PathVariable int id) {
		StudentResponse studentById = studentService.getStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(studentById);
	}

	@PostMapping("/save")
	public ResponseEntity<StudentResponse> createStudent(@RequestBody Student student) {
		StudentResponse saveStudent = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<StudentResponse> updateStudent(@PathVariable int id, @RequestBody Student student) {
		StudentResponse updateStudent = studentService.updateStudent(id, student);
		return ResponseEntity.status(HttpStatus.OK).body(updateStudent);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<StudentResponse> deleteStudent(@PathVariable int id) {
		StudentResponse deleteStudent = studentService.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleteStudent);
	}

}
