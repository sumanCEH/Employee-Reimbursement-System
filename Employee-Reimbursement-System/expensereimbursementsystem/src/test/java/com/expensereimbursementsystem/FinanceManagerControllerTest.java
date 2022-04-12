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
class FinanceManagerControllerTest {

	@Autowired
	MockMvc mvc;

	//test for get mapping for fetching all employees
	@Test
	void testAllEmployees() {

		try {
			mvc.perform(get("/finance_manager/fetchallemployees"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//test for get mapping to fetch expense by id
	@Test
	void testByExpenseId() {

		try {
			mvc.perform(get("/finance_manager/fetchbyexpenseid/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//test for get expenses by employee id
	@Test
	void testExpensesByEmployeeId() {
		try {
			mvc.perform(get("/finance_manager/fetchbyemployeeid/1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	//test for fetching all requests and checking forbidden access
	@Test
	void testAllRequestsForbidden() {
		try {
			mvc.perform(get("/finance_manager/fetchallrequests/1"))
			.andExpect(status().isForbidden());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//test for fetching all requests and checking ok access
	@Test
	void testAllRequestsOk() {
		try {
			mvc.perform(get("/finance_manager/fetchallrequests/3"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}




}
