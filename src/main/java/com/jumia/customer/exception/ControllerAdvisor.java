package com.jumia.customer.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jumia.customer.dto.GeneralResponseDto;
import com.jumia.customer.enums.MessageEnum;
import com.jumia.customer.util.ResponseUtil;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	ResponseUtil responseUtil=new ResponseUtil();
		
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public @ResponseBody ResponseEntity<Object> handleNoTFoundException(HttpServletRequest request,
	            NotFound ex) {
			GeneralResponseDto generalResponseDto = responseUtil.generateResponse(MessageEnum.INVALID_PAGE.getCode(), ex.getLocalizedMessage(), false,null);
			return new ResponseEntity<>(generalResponseDto, HttpStatus.NOT_FOUND);
	    }
	    
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public @ResponseBody ResponseEntity<Object> handleBadRequest(HttpServletRequest request,
	    		BadRequest ex) {
			GeneralResponseDto generalResponseDto = responseUtil.generateResponse(MessageEnum.INVALID_DATA.getCode(), ex.getLocalizedMessage(), false,null);
			return new ResponseEntity<>(generalResponseDto, HttpStatus.BAD_REQUEST);
	    }
	 
	
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public @ResponseBody ResponseEntity<Object> handleInternalServerError(HttpServletRequest request,
	    		Exception ex) {
			GeneralResponseDto generalResponseDto = responseUtil.generateResponse(MessageEnum.SYSTEM_ERROR.getCode(), ex.getLocalizedMessage(), false,null);
			return new ResponseEntity<>(generalResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	
	

}
