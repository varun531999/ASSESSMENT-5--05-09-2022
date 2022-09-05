package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.sevice.StudentRepo;

@RestController
public class Control1 {
	@Autowired
	private StudentRepo srepo;
	
	//Geting all data from Db
	@RequestMapping(value="/student",method = RequestMethod.GET,produces="application/json")
	public List<Student> getall(){
		return srepo.findAll();
	}
//	sending all data and saving into DB
	@PostMapping("/std_data")
	public Student getdata(@RequestBody Student student)
	{
		return srepo.save(student);
	}
// deleting data through Id from Database	
	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable("id") String id)
	{
		srepo.deleteById(id);
	}
//updating student details through student id;	
	@PutMapping("/student/{id}")
	public Student gipdate(@PathVariable("id") String id,@RequestBody Student student) {
		Optional<Student> stud=srepo.findById(id);
		Student stud1=stud.get();
		stud1.setName(student.getName());
		stud1.setStandard(student.getStandard());
		stud1.setGrade(student.getGrade());
		return srepo.save(stud1);
	}
	
}
