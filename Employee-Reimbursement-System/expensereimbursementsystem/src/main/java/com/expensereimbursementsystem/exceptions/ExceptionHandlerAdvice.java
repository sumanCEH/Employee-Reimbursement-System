package com.expensereimbursementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFound(EmployeeNotFoundException enfe)
	{
		return  new ResponseEntity<>(enfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<String> accessDenied(AccessDeniedException ade)
	{
		return  new ResponseEntity<>(ade.getMessage(),HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<String> expenseNotFound(ExpenseNotFoundException exnfe)
	{
		return  new ResponseEntity<>(exnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DeleteEmployeeException.class)
	public ResponseEntity<String> deleteEmployee(DeleteEmployeeException dex)
	{
		return  new ResponseEntity<>(dex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
}
