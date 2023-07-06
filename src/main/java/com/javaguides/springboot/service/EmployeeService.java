package com.javaguides.springboot.service;

import java.util.List;

import com.javaguides.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee,long  id);
	
	Employee deleteEmployee(long id);
}
