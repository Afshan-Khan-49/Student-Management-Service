package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	void saveStudent(Student student);
	
	Student getStudentById(Long Id);
	
	void UpdateStudent(Student student);
	
	void deleteStudentById(Long Id);
}
