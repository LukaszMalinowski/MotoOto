package com.herokuapp.apimotooto.exception.handler;

import com.herokuapp.apimotooto.exception.AnnouncementAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SaleAnnouncementHandler {

    @ExceptionHandler (value = AnnouncementAlreadyExistsException.class)
    public ResponseEntity<String> handleAnnouncementAlreadyExistsException(
            AnnouncementAlreadyExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

}
