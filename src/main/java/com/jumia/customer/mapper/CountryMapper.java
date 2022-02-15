package com.jumia.customer.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jumia.customer.dto.CountryDto;
import com.jumia.customer.model.Country;
@Mapper
public interface CountryMapper {
	
	    @Mappings({
	            @Mapping(target = "id", source = "countryDto.id"),
	            @Mapping(target = "name", source = "countryDto.name"),
	            @Mapping(target = "code", source = "countryDto.code")
	    })
	    Country mapToEntity(CountryDto countryDto);
	    
	    @Mappings({
            @Mapping(target = "id", source = "country.id"),
	        @Mapping(target = "name", source = "country.name"),
	        @Mapping(target = "code", source = "country.code")
	})
	    CountryDto mapToCountryDto(Country country);
	    
	    List<CountryDto> mapToCountryDtoList(List<Country> countries);
	}
