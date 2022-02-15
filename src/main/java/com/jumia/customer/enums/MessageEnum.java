package com.jumia.customer.enums;

public enum MessageEnum {
    INVALID_DATA(4010, "Invalid parameter"),
    INVALID_PAGE(4011, "Coudn't find"),
    SYSTEM_ERROR(5000,"System Error");
   

    public String message;

    public int code;

    private MessageEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
