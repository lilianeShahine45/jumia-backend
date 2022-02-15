package com.jumia.customer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.customer.dto.CustomerDto;
import com.jumia.customer.service.CustomerService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(path = "/customer")
	public List<CustomerDto> getAll( @RequestParam (required = false) String country,@RequestParam (required = false) String state,
			@RequestParam (required = false, defaultValue = "0") int page ,@RequestParam (required = false,defaultValue = "1000") int size) {
		 return customerService.getAllCustomers(country,state,page,size);
	}
	
}

