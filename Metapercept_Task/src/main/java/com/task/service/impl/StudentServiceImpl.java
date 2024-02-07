package com.task.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.model.ClassModel;
import com.task.model.StudentModel;
import com.task.repo.ClassRepo;
import com.task.repo.StudentRepo;
import com.task.service.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ClassRepo classRepo;

	@Override
	public ResponseEntity<?> addStudent(Long classId, StudentModel studentModel) {
		Optional<ClassModel> classOpt = classRepo.findById(classId);
		if(classOpt.isPresent()) {
			ClassModel classModel = classOpt.get();
			studentModel.setJoiningDate(LocalDateTime.now());
			List<StudentModel> students = classModel.getStudents();
			students.add(studentModel);
			classModel.setStudents(students);
			ClassModel savedClass = classRepo.save(classModel);
			return new ResponseEntity<>(savedClass,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> getStudentById(Long id) {
		Optional<StudentModel> studentOpt = studentRepo.findById(id);
		if(studentOpt.isPresent()) {
			return new ResponseEntity<>(studentOpt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> getAllStudentByClassId(Long id) {
		Optional<ClassModel> classOpt = classRepo.findById(id);
		if(classOpt.isPresent()) {
			return new ResponseEntity<>(classOpt.get().getStudents(),HttpStatus.OK);
		}
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> updateStudent(StudentModel studentModel) {
		Optional<StudentModel> studentOpt = studentRepo.findById(studentModel.getStudentId());
		if(studentOpt.isPresent()) {
			StudentModel save = studentRepo.save(studentModel);
			return new ResponseEntity<>(save,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> deleteStudent(Long id) {
		Optional<StudentModel> studentOpt = studentRepo.findById(id);
		if(studentOpt.isPresent()) {
			studentRepo.delete(studentOpt.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
