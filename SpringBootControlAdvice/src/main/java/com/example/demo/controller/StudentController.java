package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
	
	@Autowired
	 StudentService studentService;

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) throws StudentNotFoundException {
		//Log.debug("Entered into GetStudent method");
		Student studentById = studentService.getStudentById(id);
		return ResponseEntity.ok(studentById);
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@Validated @RequestBody Student student)  {
		Student savedStudent = studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}
	
	@PutMapping
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentNotFoundException{
	    Student updatedStudent = studentService.updateStudent(student);
	    return ResponseEntity.ok(updatedStudent);
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) throws StudentNotFoundException{
	     studentService.deleteStudent(id);
	     return ResponseEntity.noContent().build();
	}

}
