package com.example.lsd2.exception;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class MyException extends RuntimeException{
    private ErrorObject errorObject;
    @Autowired
    ErrorLoader errorLoader;

    public MyException(String errorCode) {
        super(errorCode);
        errorObject = ErrorObject
                .builder().errorCode(errorCode)
                .errorMessage(errorLoader.getErrorMessage(errorCode))
                .build();
    }
}
