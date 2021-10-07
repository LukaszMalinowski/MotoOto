package com.herokuapp.apimotooto.exception;

public class AnnouncementAlreadyExistsException extends RuntimeException {

    public AnnouncementAlreadyExistsException() {
        super("Announcement already exists");
    }

}
