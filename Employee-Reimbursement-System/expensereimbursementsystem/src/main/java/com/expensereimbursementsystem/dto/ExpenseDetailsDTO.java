package com.expensereimbursementsystem.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class ExpenseDetailsDTO {
	
	private Integer id;
	private String description;
	private String status;
	private LocalDate requestDate;
	private LocalDate approvalDate;
	private double amount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}
	public LocalDate getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(LocalDate approvalDate) {
		this.approvalDate = approvalDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ExpenseDetailsDTO [id=" + id + ", description=" + description + ", status=" + status + ", requestDate="
				+ requestDate + ", approvalDate=" + approvalDate + ", amount=" + amount + "]";
	}
	
	
	
}
