package com.employee.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getEmployee() {
	List<Employee> emp=	 employeeService.getAllEmployees();
	return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
		 
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable int id){
		Optional<Employee> emp=  employeeService.getEmployee(id);
		
		return new ResponseEntity<Optional<Employee>>(emp,HttpStatus.OK);
	}
	
	@PatchMapping("employee/{id}")
	public ResponseEntity<Employee> patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		Employee emp= employeeService.patchEmployee(e, id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<String> deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id){
		employeeService.deleteEmployeeByID(id);
		
		return new ResponseEntity<String>("User Deleted Successfully", HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee){
		Employee employeeDB = employeeService.addEmployee(employee);
		return new ResponseEntity<>(employeeDB,HttpStatus.CREATED);
	}
}
