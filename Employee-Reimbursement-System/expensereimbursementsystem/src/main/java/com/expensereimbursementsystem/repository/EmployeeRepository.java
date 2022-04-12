package com.expensereimbursementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.expensereimbursementsystem.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	
}
