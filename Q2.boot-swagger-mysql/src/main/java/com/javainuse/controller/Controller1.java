package com.javainuse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.dao.EmployeeRepo;
import com.javainuse.model.Employee;

@RestController
public class Controller1 {
  @Autowired
  private EmployeeRepo employeerepo;
  
  @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
		public List<Employee> getall()
  			{
	  		return employeerepo.findAll();
  			}
  
  @PostMapping
  public Employee getdata(@RequestBody Employee employee) {
	  	return employeerepo.save(employee);
	  	
	  	
  }
  
  @DeleteMapping("/employee/{id}")
  public void delete(@PathVariable("id") int id) {
	  		 employeerepo.deleteById(id);
	  
  }
	
  @GetMapping("/employee/{id}")
	 public Optional<Employee>getEmployeeById(@PathVariable("id") int id){
		        Optional<Employee> emp= employeerepo.findById(id);
		        return emp;
		    }
  @PutMapping("/employee/{id}")
  public Employee getupdate(@PathVariable("id") int id,@RequestBody Employee employee) {
	  Optional<Employee> emp=employeerepo.findById(id);
	  return employeerepo.save(employee);
	  	
  }
}
