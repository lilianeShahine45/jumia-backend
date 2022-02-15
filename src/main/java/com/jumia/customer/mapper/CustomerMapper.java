package com.jumia.customer.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jumia.customer.dto.CustomerDto;
import com.jumia.customer.model.Customer;
@Mapper
public interface CustomerMapper {
	
	    @Mappings({
	            @Mapping(target = "id", source = "customerDto.id"),
	            @Mapping(target = "name", source = "customerDto.name"),
	            @Mapping(target = "phone", source = "customerDto.phone")
	    })
	    Customer mapToEntity(CustomerDto customerDto);
	    
	    @Mappings({
	        @Mapping(target = "id", source = "customer.id"),
	        @Mapping(target = "name", source = "customer.name"),
	        @Mapping(target = "phone", source = "customer.phone")
	})
	    CustomerDto mapToCustomerDto(Customer customer);
	    
	    List<CustomerDto> mapToCustomerDtoList(List<Customer> customers);
	}
