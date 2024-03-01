package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import java.util.*;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public void addStudent(Student s)
	{
		repo.save(s); 
	}
	
	public List<Student> getAllStudent()
	{
		return repo.findAll();
	}
	public Student getStudentById(int id)
	{
		Optional<Student> s = repo.findById(id);
		if(s.isPresent())
		{
			return s.get();
		}
		return null;
	}
	public void deleteStudent(int id)
	{
		repo.deleteById(id); 
	}
}
