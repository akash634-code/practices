package com.GetPostApi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GetPostApi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByStudentAgeGreaterThanEqual(Integer studentAge);
	
	
	//public List<Student> findByStudentAge(Integer studentAge);
	
}
