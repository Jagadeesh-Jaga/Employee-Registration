package com.employee.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.management.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Transactional
	@Modifying
	@Query("update Employee e set e.firstName = :firstName where e.employeeID= :employeeID")
	int updateFirstname(@Param("firstName") String firstName,@Param("employeeID") int employeeID);

}