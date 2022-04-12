package com.expensereimbursementsystem.utils;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.dto.ExpenseDetailsDTO;
import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;

public class ConverterUtils {
	
	private ConverterUtils() {}
	
	public static void convertEmployeeDTOToEntity(EmployeeDTO employeeDto, Employee empEntity) {
		empEntity.setName(employeeDto.getName());
		empEntity.setEmail(employeeDto.getEmail());
		empEntity.setRole(employeeDto.getRole());
	}
	
	public static void convertEmployeeEntityToDTO(EmployeeDTO employeeDto, Employee empEntity) {
		employeeDto.setId(empEntity.getId());
		employeeDto.setName(empEntity.getName());
		employeeDto.setEmail(empEntity.getEmail());
		employeeDto.setRole(empEntity.getRole());
	}
	
	public static void convertExpenseDetailsDTOToEntity(ExpenseDetailsDTO expenseDetailsDTO, ExpenseDetails expenseDetails) {
		expenseDetails.setDescription(expenseDetailsDTO.getDescription());
		expenseDetails.setAmount(expenseDetailsDTO.getAmount());
		expenseDetails.setStatus(expenseDetailsDTO.getStatus());
		expenseDetails.setRequestDate(expenseDetailsDTO.getRequestDate());
		expenseDetails.setApprovalDate(expenseDetailsDTO.getApprovalDate());
	}
	
	public static void convertExpenseDetailsEntityToDTO(ExpenseDetailsDTO expenseDetailsDTO, ExpenseDetails expenseDetails) {
		expenseDetailsDTO.setId(expenseDetails.getId());
		expenseDetailsDTO.setDescription(expenseDetails.getDescription());
		expenseDetailsDTO.setAmount(expenseDetails.getAmount());
		expenseDetailsDTO.setStatus(expenseDetails.getStatus());
		expenseDetailsDTO.setRequestDate(expenseDetails.getRequestDate());
		expenseDetailsDTO.setApprovalDate(expenseDetails.getApprovalDate());
	}

}
