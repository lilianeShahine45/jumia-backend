package com.jumia.customer;



import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CustomerControllerTest  {
	

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetCustomersWithoutParameters() throws Exception {
		
	 mockMvc.perform(MockMvcRequestBuilders.get("/api/customer"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].id", is(0)));
	    }

	@Test
	public void testGetCustomersWithCountryParameter() throws Exception {
		
	 mockMvc.perform(MockMvcRequestBuilders.get("/api/customer").param("country", "212"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].phone", containsString("212")));
	    }
	
	@Test
	public void testGetCustomersWithCountryAndStateParameter() throws Exception {
		
	 mockMvc.perform(MockMvcRequestBuilders.get("/api/customer").param("country", "212").param("state", "69"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].phone", containsString("(212) 69")));
	    }
	
	@Test
	public void testGetCustomersWithNotFoundRequest() throws Exception {
		
	 mockMvc.perform(MockMvcRequestBuilders.get("/api/customers")).andExpect(status().isNotFound());
	    }
	

}