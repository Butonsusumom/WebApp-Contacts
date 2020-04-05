package com.tsubulko.exception;

public class NoSuchContactException extends RuntimeException {
    public NoSuchContactException() {
    }

    public NoSuchContactException(String message) {
        super(message);
    }
}
