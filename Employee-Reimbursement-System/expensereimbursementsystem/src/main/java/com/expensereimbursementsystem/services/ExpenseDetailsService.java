package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.dto.ExpenseDetailsDTO;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.AccessDeniedException;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;

public interface ExpenseDetailsService {
	
	public List<ExpenseDetails> fetchAll(Integer employeeId) throws ExpenseNotFoundException, 
																	EmployeeNotFoundException, 
																	AccessDeniedException;
	
	public ExpenseDetails fetchById(Integer expenseId) throws ExpenseNotFoundException;
	
	public List<ExpenseDetails> fetchByEmployeeId(Integer employeeId) throws EmployeeNotFoundException, ExpenseNotFoundException;
	
	public String addExpenseRequest(ExpenseDetailsDTO expenseDetailsDTO,Integer employeeId) throws EmployeeNotFoundException;
	
	public String updateExpense(Integer employeeId,String status, Integer id) throws EmployeeNotFoundException, 
																					 AccessDeniedException;
	
}
