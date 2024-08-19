package com.eunoia.travelschdule.global.error;

import org.springframework.http.HttpStatus;

public class CustomExpectedException extends RuntimeException{

    private final ErrorCode errorCode;

    public CustomExpectedException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public HttpStatus getStatus() {
        return errorCode.getStatus();
    }
}
