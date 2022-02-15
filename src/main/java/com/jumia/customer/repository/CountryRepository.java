package com.jumia.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jumia.customer.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
	
	 
}