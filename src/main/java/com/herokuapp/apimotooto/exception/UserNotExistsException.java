package com.herokuapp.apimotooto.exception;

public class UserNotExistsException extends RuntimeException {

    public UserNotExistsException(Long userId) {
        super("User with id " + userId + " not exists.");
    }

}
