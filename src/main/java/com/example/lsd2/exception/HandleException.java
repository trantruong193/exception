package com.example.lsd2.exception;

import com.example.lsd2.congfig.ErrorMessage;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(value = PriorityOrdered.HIGHEST_PRECEDENCE)
public class HandleException {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleException(Throwable ex, HttpServletRequest request){
        if(ex instanceof MyException){
            MyException myException = (MyException) ex;
            return new ResponseEntity<>(myException.getErrorObject(), HttpStatus.INTERNAL_SERVER_ERROR);
        }else {
            return new ResponseEntity<>(ErrorObject.builder()
                    .errorCode("500")
                    .errorMessage(ErrorMessage.builder()
                            .err_us("Something went wrong??")
                            .err_vn("Có gì đó sai sai??")
                            .build())
                    .build()
                    ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
