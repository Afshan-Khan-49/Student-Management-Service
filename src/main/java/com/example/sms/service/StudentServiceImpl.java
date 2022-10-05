package com.example.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public Student getStudentById(Long Id) {
		return studentRepository.findById(Id).get();
	}

	@Override
	public void UpdateStudent(Student student) {
	 studentRepository.save(student);
		
	}
	
	@Override
	public void deleteStudentById(Long Id) {
		studentRepository.deleteById(Id);
		
	}

}
