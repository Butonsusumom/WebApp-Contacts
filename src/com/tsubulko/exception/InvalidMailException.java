package com.tsubulko.exception;

public class InvalidMailException extends RuntimeException {

    public InvalidMailException() {
    }

    public InvalidMailException(String message) {
        super(message);
    }

}