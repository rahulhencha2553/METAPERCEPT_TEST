package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.StudentModel;

public interface StudentRepo extends JpaRepository<StudentModel, Long> {

}
