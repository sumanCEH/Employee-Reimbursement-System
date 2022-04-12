package com.expensereimbursementsystem.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementsystem.dto.ExpenseDetailsDTO;
import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.AccessDeniedException;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExceptionUtils;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;
import com.expensereimbursementsystem.repository.EmployeeRepository;
import com.expensereimbursementsystem.repository.ExpenseDetailsRepository;
import com.expensereimbursementsystem.utils.ConverterUtils;

@Service
@Transactional
public class ExpenseDetailsServiceImpl implements ExpenseDetailsService {

	@Autowired
	ExpenseDetailsRepository expenseDetailsRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ExpenseDetailsDTO expenseDetailsDTO;

	@Override
	public List<ExpenseDetails> fetchAll(Integer employeeId) throws ExpenseNotFoundException, 
																	EmployeeNotFoundException, 
																	AccessDeniedException {
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) throw new EmployeeNotFoundException(ExceptionUtils.EMPLOYEE_NOT_FOUND);
		else {
			if(employee
					.get()
					.getRole()
					.toLowerCase()
					.compareTo("finance manager")!=0) throw new AccessDeniedException("You Have No Access");
		}
		
		List<ExpenseDetails> expenseDetails = (List<ExpenseDetails>) expenseDetailsRepository.findAll();
		if(expenseDetails.isEmpty()) throw new ExpenseNotFoundException("No Expense Requests Found");
		else {
			return expenseDetails;
		}
		
	}

	@Override
	public ExpenseDetails fetchById(Integer expenseId) throws ExpenseNotFoundException {
		
		Optional<ExpenseDetails> expenseDetails = expenseDetailsRepository.findById(expenseId);
		if(expenseDetails.isPresent()) {
			return expenseDetails.get();
		}
		else throw new ExpenseNotFoundException("Expense Details Not Found");

	}

	@Override
	public List<ExpenseDetails> fetchByEmployeeId(Integer employeeId) throws EmployeeNotFoundException, ExpenseNotFoundException {
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) throw new EmployeeNotFoundException(ExceptionUtils.EMPLOYEE_NOT_FOUND);
		else {
			List<ExpenseDetails> expenseDetails = employee.get().getExpenseRequests();
			if(expenseDetails.isEmpty()) throw new ExpenseNotFoundException("No Expenses Found");
			return expenseDetails;
		}
		
	}
	
	@Override
	public String addExpenseRequest(ExpenseDetailsDTO expenseDetailsDTO, Integer employeeId) throws EmployeeNotFoundException {
		Optional<Employee> result = employeeRepository.findById(employeeId);
		if(!result.isPresent()) throw new EmployeeNotFoundException(ExceptionUtils.EMPLOYEE_NOT_FOUND);
		else {
			Employee employee = result.get();
			ExpenseDetails expenseDetails = new ExpenseDetails();
			ConverterUtils.convertExpenseDetailsDTOToEntity(expenseDetailsDTO, expenseDetails);
			expenseDetailsRepository.save(expenseDetails);
			employee.add(expenseDetails);
			employeeRepository.save(employee);
			return "Request Submitted Successfully";
		}
	}

	@Override
	public String updateExpense(Integer employeeId,String status, Integer id) throws EmployeeNotFoundException, 
																					 AccessDeniedException {
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) throw new EmployeeNotFoundException(ExceptionUtils.EMPLOYEE_NOT_FOUND);
		else {
			if(employee
					.get()
					.getRole()
					.toLowerCase()
					.compareTo("finance manager")!=0) throw new AccessDeniedException("You Have No Access");
		}
		Integer row = expenseDetailsRepository.updateStatus(status, id,LocalDate.now());
		return row + " updated";
		
	}

	

}
