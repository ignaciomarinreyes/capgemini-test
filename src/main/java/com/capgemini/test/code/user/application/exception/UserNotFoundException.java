package com.capgemini.test.code.user.application.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("El usuario " + id + " no existe");
    }
}
