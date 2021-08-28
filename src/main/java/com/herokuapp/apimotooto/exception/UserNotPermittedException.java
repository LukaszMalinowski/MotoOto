package com.herokuapp.apimotooto.exception;

public class UserNotPermittedException extends RuntimeException {

    public UserNotPermittedException(String message) {
        super(message);
    }

}
