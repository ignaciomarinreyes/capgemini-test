package com.capgemini.test.code.user.application.exception;

public class InvalidDniException extends RuntimeException {

    public InvalidDniException(String message) {
        super(message);
    }
}
