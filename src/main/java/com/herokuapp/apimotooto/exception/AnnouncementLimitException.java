package com.herokuapp.apimotooto.exception;

public class AnnouncementLimitException extends RuntimeException {

    public AnnouncementLimitException() {
        super("You can only have 3 announcements");
    }

}
