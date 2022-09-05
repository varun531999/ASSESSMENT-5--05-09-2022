package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
