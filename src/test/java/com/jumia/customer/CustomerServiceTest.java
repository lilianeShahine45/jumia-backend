package com.jumia.customer;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jumia.customer.dto.CustomerDto;
import com.jumia.customer.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest  {
	

    @Autowired
    private CustomerService customerService;

	@Test
	public void testWithNoParamters() throws Exception {		
		List<CustomerDto> list=customerService.getAllCustomers("","",0,1000);
		assertFalse(list.isEmpty());
	    }
	
	
	@Test
	public void testWithCountryParamter() throws Exception {
		List<CustomerDto> list=customerService.getAllCustomers("256","",0,1000);
		assertFalse(list.isEmpty());
	    }
	
	@Test
	public void testWithStateParamter() throws Exception {		
		List<CustomerDto> list=customerService.getAllCustomers("","61",0,0);
		assertTrue(list.isEmpty());
	    }
	
	
	@Test
	public void testWithCountryAndTrueStateParamter() throws Exception {
		List<CustomerDto> list=customerService.getAllCustomers("256","77",0,1000);
		assertFalse(list.isEmpty());
	    }
	
	@Test
	public void testWithCountryAndWrongStateParamter() throws Exception {
		List<CustomerDto> list=customerService.getAllCustomers("256","61",0,1000);
		assertTrue(list.isEmpty());
	    }

}