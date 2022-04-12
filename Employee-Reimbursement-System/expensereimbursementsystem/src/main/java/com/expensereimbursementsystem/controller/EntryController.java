package com.expensereimbursementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.UserCredentials;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.services.EmployeeService;

@RestController
@RequestMapping("/")
public class EntryController {

	@Autowired
	EmployeeService employeeService;


	@PostMapping("/register")
	public ResponseEntity<Employee>register(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestBody EmployeeDTO employeeDto) {

		UserCredentials userCredentials = new UserCredentials(username, password);

		return new ResponseEntity<>(employeeService.addEmployee(employeeDto, userCredentials),HttpStatus.OK);

	}
	
	// mapping for login of an employee
	@GetMapping("/login")
	public ResponseEntity<Employee>login(@RequestParam("username") String username,
			@RequestParam("password") String password) throws EmployeeNotFoundException {

		return new ResponseEntity<>(employeeService.login(username, password),HttpStatus.OK);

	}

}
