package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.StudentModel;
import com.task.service.IStudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;

	@PostMapping
	public ResponseEntity<?> addStudent(@RequestParam("id") Long classId,@RequestBody StudentModel studentModel){
		System.out.println(classId);
		return studentService.addStudent(classId,studentModel);
	}
	
	@GetMapping
	public ResponseEntity<?> getStudentById(@RequestParam("id") Long id){
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getAllStudentByClassId(@RequestParam("id") Long id){
		return studentService.getAllStudentByClassId(id);
	}
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody StudentModel studentModel){
		return studentService.updateStudent(studentModel);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteStudent(@RequestParam("id") Long id){
		return studentService.deleteStudent(id);
	}

}