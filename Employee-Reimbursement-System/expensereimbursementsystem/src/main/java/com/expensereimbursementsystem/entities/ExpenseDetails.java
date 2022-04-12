package com.expensereimbursementsystem.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "expense_details")
public class ExpenseDetails {

	@Id
	@GeneratedValue(generator = "Expense_SequenceStyleGenerator")
	@GenericGenerator(name = "Expense_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "Expense_SEQ"),
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") }
			)
	@Column(name = "request_id")
	private Integer id;

	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private String status;

	@Column(name = "request_date")
	private LocalDate requestDate;

	@Column(name = "approval_date")
	private LocalDate approvalDate;

	@Column(name = "amount")
	private double amount;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "employee_id_fk",referencedColumnName = "employee_id")
	private Employee employee;

	
	// Default Constructor
	
	public ExpenseDetails() {}

	//Parameterized Constructors
	
	public ExpenseDetails(String description, String status, LocalDate requestDate, LocalDate approvalDate,
			double amount) {
		this.description = description;
		this.status = status;
		this.requestDate = requestDate;
		this.approvalDate = approvalDate;
		this.amount = amount;
	}

	
	//Getters and Setters
	
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

	//toString method
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", description=" + description + ", status=" + status + ", requestDate="
				+ requestDate + ", approvalDate=" + approvalDate + ", amount=" + amount + "]";
	}

}
