package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springboot.model.Employee;
import com.javaguides.springboot.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//Home Page
		@GetMapping()
		public String start() {
			
			return "Home Page";
		}
		
	// build create employee REST API
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	// build get all employees REST API
	@GetMapping("/get-all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//build get Employee by ID REST API 
	@GetMapping("/get-employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee> (employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	
	//build update Employee REST API
	@PutMapping("/update-employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee){
		return new ResponseEntity<Employee> (employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
	}
	 
	
	//build delete Employee REST API
	@DeleteMapping("delete-employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee> (employeeService.deleteEmployee(employeeId), HttpStatus.OK);
	}
	

}
 