package com.jumia.customer.util;

import org.springframework.stereotype.Component;
import com.jumia.customer.dto.GeneralResponseDto;


@Component
public class ResponseUtil {
	
  
public GeneralResponseDto generateResponse(int code ,String message , boolean success,Object obj)	
{
	GeneralResponseDto generalResponseDto = new GeneralResponseDto();
	generalResponseDto.setCode(code);
	generalResponseDto.setMessage(message);
	generalResponseDto.setData(obj);
	generalResponseDto.setSuccess(success);
	return generalResponseDto;
}
	
}