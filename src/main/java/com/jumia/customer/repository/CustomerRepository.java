package com.jumia.customer.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jumia.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByPhoneContaining(String countryCode,Pageable pageable);
	
	List<Customer> findByPhoneContaining(String countryCode);
	 
}