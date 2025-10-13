package com.capgemini.test.code.user.application.exception;

public class InvalidNameException extends RuntimeException{

    public InvalidNameException(String message) {
        super(message);
    }
}
