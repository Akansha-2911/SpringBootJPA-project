package com.springboot.springbootJPAWeb.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springbootJPAWeb.model.Student;
import com.springboot.springbootJPAWeb.repository.StudentRepository;
import com.springboot.springbootJPAWeb.servicei.StudentServiceI;


@Service
public class StudentServiceImpl implements StudentServiceI{
	
	@Autowired
	StudentRepository sr;

	@Override
	public void addStudent(Student s) {
		
		sr.save(s);	
	}

	@Override
	public List<Student> getAllStudents() {
		
		return (List<Student>)sr.findAll();
	}

	@Override
	public List<Student> loginCheck(String username, String password) {
		
		return sr.findByUsernameAndPassword(username,password);
		
	}

	@Override
	public void deleteStudent(int rollno) {
		
		sr.deleteById(rollno);
		
	}

	@Override
	public Student editStudent(int rollno) {
		Optional<Student> op=sr.findById(rollno);
		
		if(op.isPresent()) {
			Student s=op.get();
			
			return s;
		}
		
		return null;
	}

	@Override
	public void updateStudent(Student s) {
		
		sr.save(s);
		
		
	}
	
	
	
	

}
