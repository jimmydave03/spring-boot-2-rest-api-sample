package com.outlead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.outlead.entity.Student;
import com.outlead.exception.StudentNotFoundException;
import com.outlead.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping
	public ResponseEntity<Student> save(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> fetchAll() {
		List<Student> studentsList = studentRepository.findAll();
		return new ResponseEntity<>(studentsList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> fetchOne(@PathVariable Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student newStudent) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		
		//We will need to use same approach for all properties.
		if(!StringUtils.isEmpty(newStudent.getEmail())) {
			student.setEmail(newStudent.getEmail());
		}

		student.setFirstName(newStudent.getFirstName());
		student.setLastName(newStudent.getLastName());
		student.setGrade(newStudent.getGrade());
		student.setRollNo(newStudent.getRollNo());
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable Long id) {
		studentRepository.deleteById(id);
	}
}
