package com.jumia.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.customer.builder.FilterBuilder;
import com.jumia.customer.dto.CustomerDto;
import com.jumia.customer.enums.StrategyName;
import com.jumia.customer.mapper.CustomerMapper;
import com.jumia.customer.strategy.SearchStrategy;
import com.jumia.customer.strategy.SearchStrategyFactory;

@Service
public class CustomerService {

	CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

	@Autowired
	private SearchStrategyFactory strategyFactory;

	public List<CustomerDto> getAllCustomers(String country, String state,int page,int size) {
		FilterBuilder filterBuilder = FilterBuilder.builder() .country(country).state(state).build();
		SearchStrategy searchStrategy=generateSearchStrategy(filterBuilder);
		if(searchStrategy==null)	return new ArrayList<>();
		
		return customerMapper.mapToCustomerDtoList(searchStrategy.search(filterBuilder,page,size));
	}

	private SearchStrategy generateSearchStrategy(FilterBuilder filterBuilder) {
		SearchStrategy searchStrategy;
		if (filterBuilder != null && filterBuilder.getCountry() != null && !filterBuilder.getCountry().isEmpty()) {
			if (filterBuilder.getState() != null && !filterBuilder.getState().isEmpty())
				searchStrategy = strategyFactory.findStrategy(StrategyName.StateSearchStrategy);
			else
				searchStrategy = strategyFactory.findStrategy(StrategyName.CountrySearchStrategy);
		} else {
			if (filterBuilder.getState() != null && !filterBuilder.getState().isEmpty())
				return null;
			
			searchStrategy = strategyFactory.findStrategy(StrategyName.AllItemStrategy);
		}
		return searchStrategy;

	}
}
