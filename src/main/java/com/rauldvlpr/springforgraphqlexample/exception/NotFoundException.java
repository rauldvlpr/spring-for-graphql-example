package com.rauldvlpr.springforgraphqlexample.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
