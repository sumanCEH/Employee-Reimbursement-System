package com.expensereimbursementsystem.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.expensereimbursementsystem.entities.ExpenseDetails;

public interface ExpenseDetailsRepository extends CrudRepository<ExpenseDetails, Integer> {

	@Modifying
	@Query("update ExpenseDetails ed set ed.status=:status , ed.approvalDate=:approvalDate where ed.id=:id")
	public Integer updateStatus(@Param("status") String status,
								@Param("id") Integer id,
								@Param("approvalDate") LocalDate approvalDate); 
	
}
