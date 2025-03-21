
package com.springboot.springbootJPAWeb.servicei;

import java.util.List;

import com.springboot.springbootJPAWeb.model.Student;

public interface StudentServiceI {
	
	public void addStudent(Student s);

	public List<Student> getAllStudents();

	public List<Student> loginCheck(String username, String password);

	public void deleteStudent(int rollno);

	public Student editStudent(int rollno);

	public void updateStudent(Student s);

	

}
