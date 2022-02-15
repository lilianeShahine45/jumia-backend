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
public class StateSearch implements SearchStrategy{
	
@Autowired	
CustomerRepository customerRepository;
	@Override
	public List<Customer> search(FilterBuilder filterBuilder,int page,int size) {
		StringBuilder countrySatecode=new StringBuilder("(").
	    append(filterBuilder.getCountry()).append(")").append(" ").append(filterBuilder.getState());
		Pageable pageable =PageRequest.of(page, size);
		return customerRepository.findByPhoneContaining(countrySatecode.toString(),pageable);
	}
	@Override
	public StrategyName getStrategyName() {
		return StrategyName.StateSearchStrategy;
	}

}
