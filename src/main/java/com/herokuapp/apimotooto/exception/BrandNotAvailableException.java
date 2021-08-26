package com.herokuapp.apimotooto.exception;

public class BrandNotAvailableException extends RuntimeException {

    public BrandNotAvailableException(String brand) {
        super("Brand " + brand + " not available.");
    }
}
