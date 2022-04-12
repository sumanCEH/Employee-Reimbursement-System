package com.expensereimbursementsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.dto.ExpenseDetailsDTO;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;
import com.expensereimbursementsystem.services.EmployeeService;
import com.expensereimbursementsystem.services.ExpenseDetailsService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ExpenseDetailsService expenseDetailsService;

	// view employee by id 
	@GetMapping("/getEmployee/{id}")
	public  ResponseEntity<EmployeeDTO> viewEmployeeById(@PathVariable(value = "id") Integer employeeId) throws EmployeeNotFoundException {
		return new ResponseEntity<>(employeeService.viewEmployeeById(employeeId),HttpStatus.OK);
	}

	// view expense details by id
	@GetMapping("/getByExpenseId/{expenseid}")
	public ResponseEntity<ExpenseDetails> fetchById(@PathVariable(value = "expenseid") Integer expenseId) throws ExpenseNotFoundException {
		return new ResponseEntity<>(expenseDetailsService.fetchById(expenseId),HttpStatus.OK);
	}

	// view expense details by employee id (will return a list)
	@GetMapping("/getAllExpenses/{employeeid}")
	public ResponseEntity<List<ExpenseDetails>> fetchByEmployeeId(@PathVariable(value ="employeeid") Integer employeeId) throws EmployeeNotFoundException, ExpenseNotFoundException {
		return new ResponseEntity<>(expenseDetailsService.fetchByEmployeeId(employeeId),HttpStatus.OK);
	}
	
	//add request
	@PostMapping("/addRequest/{employeeid}")
	public ResponseEntity<String> addRequest(@PathVariable(value = "employeeid") Integer employeeId,
											 @RequestBody ExpenseDetailsDTO expenseDetailsDTO) throws EmployeeNotFoundException{
		
		expenseDetailsDTO.setRequestDate(LocalDate.now());
		expenseDetailsDTO.setStatus("new");
		
		return new ResponseEntity<>(expenseDetailsService.addExpenseRequest(expenseDetailsDTO, employeeId),HttpStatus.OK);
		
	}
	


}
