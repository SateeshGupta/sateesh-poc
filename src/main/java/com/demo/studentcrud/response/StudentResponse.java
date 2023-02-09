package com.demo.studentcrud.response;

import java.time.LocalDateTime; 

public class StudentResponse {

	private String status;
	private String message;
	private LocalDateTime dateAndTime = LocalDateTime.now();
	private Object data;

	public LocalDateTime getDate() {
		return dateAndTime;
	}

	public void setDate(LocalDateTime date) {
		this.dateAndTime = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
