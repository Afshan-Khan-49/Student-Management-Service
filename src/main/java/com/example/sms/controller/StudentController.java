package com.example.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{Id}")
	public String editStudentForm(@PathVariable Long Id,Model model) {
		model.addAttribute("student", studentService.getStudentById(Id));
		return "edit_student";
	}
	
	@GetMapping("/students/delete/{Id}")
	public String deleteStudent(@PathVariable Long Id) {
		studentService.deleteStudentById(Id);
		return "redirect:/students";
	}
	
	
	@PostMapping("/students/{Id}")
	public String updateStudent(@PathVariable Long Id,@ModelAttribute("student") Student student,Model model) {
		Student existingStudent = studentService.getStudentById(Id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setId(Id);
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		studentService.UpdateStudent(existingStudent);
		return "redirect:/students";
	}
}
