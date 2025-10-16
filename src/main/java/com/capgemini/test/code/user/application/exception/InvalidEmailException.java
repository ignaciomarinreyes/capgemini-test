package com.capgemini.test.code.user.application.exception;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(String email) {
        super("Error validation email " + email);
    }
}
