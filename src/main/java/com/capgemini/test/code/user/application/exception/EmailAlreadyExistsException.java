package com.capgemini.test.code.user.application.exception;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String email) {
        super("El email " + email + " ya existe. No se puede crear el usuario");
    }
}
