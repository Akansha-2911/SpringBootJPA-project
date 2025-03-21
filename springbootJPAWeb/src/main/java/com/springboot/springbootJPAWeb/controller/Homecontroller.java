package com.springboot.springbootJPAWeb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.springbootJPAWeb.model.Student;
import com.springboot.springbootJPAWeb.servicei.StudentServiceI;

@Controller
public class Homecontroller {
	
	List<Student> list=new ArrayList<Student>();
	
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String prelogin()
	{
		
		return "login";	
		
	}
	
	@RequestMapping("/openreg")
	public String preregister()
	{
		
		return "Register";
	}
	
	@RequestMapping("/savedata")
	public String saveData(@ModelAttribute Student s)
	{
		System.out.println(s);
		ssi.addStudent(s);
		
		return "login";
	}
	@RequestMapping("/login")
	public String loginCheck(@RequestParam("username") String username,@RequestParam("password") String password, Model m)
	{
		if(username.equals("ADMIN") && password.equals("ADMIN"))
		{
			List<Student> list=ssi.getAllStudents();
			m.addAttribute("data",list);
	
			return "success";		
	}
		else
		{
			List<Student> list=ssi.loginCheck(username,password);
			if(!list.isEmpty())
			{
				m.addAttribute("data",list);	
				return "success";
			}else
			{
				return "login";
			}
			
		}
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("rollno") int rollno,Model m)
	{
		ssi.deleteStudent(rollno);
		
		List<Student> list=ssi.getAllStudents();
		
		m.addAttribute("data",list);
		
		return "success";
		
	}
	
	
	@RequestMapping("/edit")
	public String editStudent(@RequestParam("rollno") int rollno,Model m)
	{
		Student s=ssi.editStudent(rollno);
		if(s!=null)
		{
			m.addAttribute("stu", s);
			return "Edit";
			
		}
		else {
			return "login";
		}	
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s, Model m) {
		
		ssi.updateStudent(s);
		List<Student> list=ssi.getAllStudents();	
		m.addAttribute("data",list);
		return "success";
		
	}

}
