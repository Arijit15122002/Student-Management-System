package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import jakarta.servlet.http.HttpSession;
import java.util.*;

@Controller
public class EmpController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Student> stu = service.getAllStudent();
		m.addAttribute("stu", stu);
		return "index";
	}
	@GetMapping("/add-student")
	public String addStudentForm()
	{
		return "add-student";
	}
	
	@PostMapping("/register")
	public String stuRegister(@ModelAttribute Student s, HttpSession session)
	{
		service.addStudent(s);
		session.setAttribute("msg", "Student was added Successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		Student s = service.getStudentById(id);
		m.addAttribute("stu", s);
		return "edit";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id, Model m)
	{
		service.deleteStudent(id);
		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student s)
	{
		service.addStudent(s);
		return "redirect:/";
	}
}
