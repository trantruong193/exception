package com.example.lsd2.exception;

import com.example.lsd2.congfig.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorObject {
    private String errorCode;
    private ErrorMessage errorMessage;
}
