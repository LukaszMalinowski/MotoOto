package com.herokuapp.apimotooto.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler (value = MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(MethodArgumentNotValidException exception) {
        ObjectError objectError = exception.getAllErrors()
                                           .stream()
                                           .findFirst()
                                           .orElse(new ObjectError("Object", "Object error"));
        return new ResponseEntity<>(objectError.getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }
}
