package com.jumia.customer.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.jumia.customer.builder.FilterBuilder;
import com.jumia.customer.enums.StrategyName;
import com.jumia.customer.model.Customer;
import com.jumia.customer.repository.CustomerRepository;
@Component
public class AllItemsSearch implements SearchStrategy{
	
@Autowired	
CustomerRepository customerRepository;
	@Override
	public List<Customer> search(FilterBuilder filterBuilder,int page,int size) {
		Pageable pageable =PageRequest.of(page, size);
		return  customerRepository.findAll(pageable).getContent();
	}
	@Override
	public StrategyName getStrategyName() {
		return StrategyName.AllItemStrategy;
	}

}
