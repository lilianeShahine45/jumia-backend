package com.jumia.customer.strategy;

import java.util.List;
import com.jumia.customer.builder.FilterBuilder;
import com.jumia.customer.enums.StrategyName;
import com.jumia.customer.model.Customer;


public interface SearchStrategy {
	List<Customer> search(FilterBuilder filterBuilder,int page,int size);
	StrategyName getStrategyName();
}