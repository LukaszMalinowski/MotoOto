package com.herokuapp.apimotooto.exception.handler;

import com.herokuapp.apimotooto.exception.BrandNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarExceptionHandler {

    @ExceptionHandler (value = BrandNotAvailableException.class)
    public ResponseEntity<String> handleBrandNotAvailableException(BrandNotAvailableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
