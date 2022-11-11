package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;

// employee service class
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// fetching all employees
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>) employeeRepository.findAll();
		return emps;
	}

	// fetching employee by id
	public Optional<Employee> getEmployee(int id) {
		return employeeRepository.findById(id);
	}

	// inserting employee
	public Employee addEmployee(Employee e) {
		Employee employee = employeeRepository.save(e);
		return employee;

	}

	public Employee patchEmployee(Employee emp, int id) {
			int status= employeeRepository.updateFirstname(emp.getFirstName(), id);
			if(status==1) {
				return getEmployee(id).get();
		}
		return null;
		
	}

	public void deleteEmployeeByID(int id){
		employeeRepository.deleteById(id);
	}
}
