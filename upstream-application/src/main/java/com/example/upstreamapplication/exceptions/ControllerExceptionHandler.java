package com.example.schematenancy.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleItemNotFoundException(ItemNotFoundException exception) {
        ExceptionResponse body = ExceptionResponse.builder()
                .message(exception.getMessage())
                .errorDescription(exception.getErrorDescription())
                .error(exception.getError())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(body, exception.getHttpStatus());
    }

}
