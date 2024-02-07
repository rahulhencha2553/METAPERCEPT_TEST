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

import com.task.model.ClassModel;
import com.task.service.IClassService;

@RestController
@RequestMapping("/class")
@CrossOrigin("*")
public class ClassController {
	
	@Autowired
	private IClassService classService;

	@PostMapping
	public ResponseEntity<?> addClass(@RequestBody ClassModel classModel){
		return classService.addClass(classModel);
	}
	
	@GetMapping
	public ResponseEntity<?> getClassById(@RequestParam("id") Long id){
		return classService.getClassById(id);
	}
	
	@GetMapping("/getAllClasses")
	public ResponseEntity<?> getAllClasses(){
		return classService.getAllClasses();
	}
	
	@PutMapping
	public ResponseEntity<?> updateClass(@RequestBody ClassModel classModel){
		return classService.updateClass(classModel);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteClass(@RequestParam("id") Long id){
		return classService.deleteClass(id);
	}
	
}
