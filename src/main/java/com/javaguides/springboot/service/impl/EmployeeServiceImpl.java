package com.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaguides.springboot.exception.ResourceNotFoundException;
import com.javaguides.springboot.model.Employee;
import com.javaguides.springboot.repository.EmployeeRepository;
import com.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	private EmployeeRepository employeeRepository;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}



	@Override
	public Employee getEmployeeById(long id) {
		 
//		Optional<Employee> employee = employeeRepository.findById(id);
		
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check whether employee with given id is present in DB or not
		Employee existingEmployee = employeeRepository.findById(id)
													  .orElseThrow(
													  () -> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}



	@Override
	public Employee deleteEmployee(long id) {
		
		//find
		Employee existingEmployee = employeeRepository.findById(id)
				  .orElseThrow(
				  () -> new ResourceNotFoundException("Employee", "Id", id));
		
		//delete
		employeeRepository.deleteById(id);
		
		return existingEmployee;
	}


}
 