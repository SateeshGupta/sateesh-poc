package com.demo.studentcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.studentcrud.dao.StudentRepo;
import com.demo.studentcrud.entity.Student;
import com.demo.studentcrud.exception.AlreadyPresentException;
import com.demo.studentcrud.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	// Getting All Students Records :----------->
	@Override
	public StudentResponse getAllStudents() {
		List<Student> allStudents = studentRepo.findAll();
		StudentResponse response = new StudentResponse();
		response.setStatus("Success");
		response.setMessage("Number of Total Students Available are : " + allStudents.size());
		response.setData(allStudents);
		return response;

	}

	// Find Students By their ID :----->
	@Override
	public StudentResponse getStudentById(int id) {
		Optional<Student> optional = studentRepo.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("Student for id - " + id + " is not found");
		}
		StudentResponse response = new StudentResponse();
		response.setStatus("Success");
		response.setMessage("Student Found for id - " + id);
		response.setData(optional.get());
		return response;
	}

	// Saving Students For the Fist time --------->
	@Override
	public StudentResponse saveStudent(Student student) {

		Optional<Student> findByEmail = studentRepo.findByEmail(student.getEmail());

		if (findByEmail.isPresent()) {
			throw new AlreadyPresentException("Students with email " + student.getEmail() + " is Already Present");
		}

		Student saveStd = studentRepo.save(student);
		StudentResponse response = new StudentResponse();
		response.setStatus("Success");
		response.setMessage("Student successfully created for id : " + saveStd.getId());
		response.setData(saveStd);
		return response;
	}

	// updating exiting records ------->
	@Override
	public StudentResponse updateStudent(int id, Student student) {
		Optional<Student> optional = studentRepo.findById(id);
		// System.out.println(optional.get());
		if (!optional.isPresent()) {
			throw new RuntimeException("Student for id - " + id + " is not found");
		}
		Student studentNew = optional.get();
		studentNew.setName(student.getName());
		studentNew.setAge(student.getAge());
		studentNew.setEmail(student.getEmail());
		studentNew.setBranch(student.getBranch());

		Student updatedStudent = studentRepo.save(studentNew);

		StudentResponse response = new StudentResponse();
		response.setStatus("Success");
		response.setMessage("Student for id " + id + " is updated successfully");
		response.setData(updatedStudent);
		return response;

	}

	// Delete records by Id :------>
	@Override
	public StudentResponse deleteStudent(int id) {

		studentRepo.deleteById(id);
		StudentResponse response = new StudentResponse();
		response.setStatus("Success");
		response.setMessage("Student Deleted SuccessFully for ID : " + id);
		return response;
	}

}
