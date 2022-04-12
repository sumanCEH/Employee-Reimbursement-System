package com.expensereimbursementsystem;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest()
@AutoConfigureMockMvc
class EmployeeControllerTest {
	
	@Autowired
	MockMvc mvc;

	//test for get mapping for fetching employee by id
	@Test
	void testByEmployeeById() {
		
		try {
			mvc.perform(get("/employee/getEmployee/1"))
			  .andExpect(status().isOk())
			  .andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//TODO test for get mapping for fetching expense by id
	@Test
	void testByExpenseId() {
		
		try {
			mvc.perform(get("/employee/getByExpenseId/1"))
			  .andExpect(status().isOk())
			  .andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	//TODO test for viewing expense details by employee id
	
	@Test
	void testExpenseByEmployeeId() {
		
		try {
			mvc.perform(get("/employee/getAllExpenses/1"))
			  .andExpect(status().isOk())
			  .andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}




