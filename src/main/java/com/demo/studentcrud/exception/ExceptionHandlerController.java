package com.demo.studentcrud.exception;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.studentcrud.response.StudentResponse;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<StudentResponse> handleException(Exception e) {

		StudentResponse response = new StudentResponse();

		response.setStatus("Failure");
		response.setMessage(e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<StudentResponse> handleRunTimeException(RuntimeException e) {
		StudentResponse response = new StudentResponse();
		response.setStatus("Failure");
		response.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(AlreadyPresentException.class)
	public ResponseEntity<StudentResponse> handleAlreadyPresentException(AlreadyPresentException ex) {
		StudentResponse response = new StudentResponse();
		response.setStatus("Failure");
		response.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}
