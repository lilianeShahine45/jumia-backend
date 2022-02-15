package com.jumia.customer.dto;


import lombok.Data;

@Data
public class GeneralResponseDto {

private int code;
private boolean success;
private String message;
private Object data;
}
