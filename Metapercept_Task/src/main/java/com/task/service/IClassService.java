package com.task.service;

import org.springframework.http.ResponseEntity;

import com.task.model.ClassModel;

public interface IClassService {

	ResponseEntity<?> addClass(ClassModel classModel);

	ResponseEntity<?> getClassById(Long id);

	ResponseEntity<?> getAllClasses();

	ResponseEntity<?> updateClass(ClassModel classModel);

	ResponseEntity<?> deleteClass(Long id);

}
