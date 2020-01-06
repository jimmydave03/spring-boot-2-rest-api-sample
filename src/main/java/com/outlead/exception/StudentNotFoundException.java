package com.outlead.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException(Long id) {
		super("Student not found for id: "+ id);
	}
}
