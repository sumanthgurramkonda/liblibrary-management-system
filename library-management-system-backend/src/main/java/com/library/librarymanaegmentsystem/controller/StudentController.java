package com.library.librarymanaegmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.librarymanaegmentsystem.entity.Student;
import com.library.librarymanaegmentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void addStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
	}
	
	@GetMapping("/get/{rollNo}")
	public Student getStudentByRollNo(@PathVariable("rollNo") long rollNo){
		
		return studentService.getStudentBydRollNo(rollNo);
	}
	@PutMapping("/{rollNumber}/books/{serialIds}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void addBooksToStudent(@PathVariable("rollNumber") long rollNumber, @PathVariable("serialIds") List<Long> serialIds) {
		
		studentService.addBooks(rollNumber,serialIds);
	}

}


