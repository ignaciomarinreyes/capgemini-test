package com.capgemini.test.code.user.application.exception;

public class InvalidEmailException extends RuntimeException{

    public InvalidEmailException(String email) {
        super("El email " + email + " no es válido. No se puede crear el usuario");
    }
}
