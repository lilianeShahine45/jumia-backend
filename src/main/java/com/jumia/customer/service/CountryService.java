package com.jumia.customer.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jumia.customer.repository.CountryRepository;
import com.jumia.customer.dto.CountryDto;
import com.jumia.customer.mapper.CountryMapper;


@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	CountryMapper countryMapper = Mappers.getMapper(CountryMapper.class);



	public List<CountryDto> getAllCountries() {
	
		return countryMapper.mapToCountryDtoList(countryRepository.findAll());
	}

	
}
