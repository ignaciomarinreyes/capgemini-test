package com.capgemini.test.code.user.application.exception;

public class InvalidDniException extends RuntimeException {

    public InvalidDniException(String dni) {
        super("Error validation dni " + dni);
    }
}
