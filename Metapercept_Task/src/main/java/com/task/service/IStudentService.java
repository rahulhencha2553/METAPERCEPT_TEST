package com.task.service;

import org.springframework.http.ResponseEntity;

import com.task.model.StudentModel;

public interface IStudentService {

	ResponseEntity<?> addStudent(Long classId, StudentModel studentModel);

	ResponseEntity<?> getStudentById(Long id);

	ResponseEntity<?> getAllStudentByClassId(Long id);

	ResponseEntity<?> updateStudent(StudentModel studentModel);

	ResponseEntity<?> deleteStudent(Long id);



}
