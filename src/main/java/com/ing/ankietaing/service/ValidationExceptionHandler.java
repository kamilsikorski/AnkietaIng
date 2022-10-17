package com.ing.ankietaing.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<Object> exception(ValidationException exception) {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }



}