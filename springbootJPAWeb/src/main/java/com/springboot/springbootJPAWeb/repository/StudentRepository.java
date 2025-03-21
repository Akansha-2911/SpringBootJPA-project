package com.springboot.springbootJPAWeb.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springboot.springbootJPAWeb.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

	public List<Student> findByUsernameAndPassword(String username, String password);

}
