package com.jumia.customer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.customer.dto.CountryDto;
import com.jumia.customer.service.CountryService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/api")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping(path = "/countries")
	public List<CountryDto> getAll() {
		 return countryService.getAllCountries();
	}
	
}
