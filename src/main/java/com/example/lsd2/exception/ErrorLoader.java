package com.example.lsd2.exception;

import com.example.lsd2.congfig.ErrorConfig;
import com.example.lsd2.congfig.ErrorMessage;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
public class ErrorLoader {
    private ErrorConfig errorConfig;
    private static Map<String, ErrorMessage> errorMessageMap;

    @Autowired
    public ErrorLoader(ErrorConfig errorConfig){
        this.errorConfig = errorConfig;
        this.errorMessageMap = errorConfig.getErrorMessage();
    }
    public static ErrorMessage getErrorMessage(String errorCode){
        return errorMessageMap.get(errorCode);
    }
}
