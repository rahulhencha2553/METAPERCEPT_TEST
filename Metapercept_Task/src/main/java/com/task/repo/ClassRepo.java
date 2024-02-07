package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.ClassModel;

public interface ClassRepo extends JpaRepository<ClassModel, Long> {

	public ClassModel findByClassName(String className);

}