package com.expensereimbursementsystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user_credentials")
public class UserCredentials {

	@Id
	@GeneratedValue(generator = "UserCreds_SequenceStyleGenerator")
	@GenericGenerator(name = "UserCreds_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "usercreds_SEQ"),
			@Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1") }
			)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private  String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id_fk",referencedColumnName = "employee_id")
	private Employee employee;
	
	
	//default constructor
	
	public UserCredentials() {}
	
	
	//parameterized constructor
	
	public UserCredentials(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}


	//getters and setters

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	//toString method
	@Override
	public String toString() {
		return "UserCredentials [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", employee=" + employee + "]";
	}
	
	
}
