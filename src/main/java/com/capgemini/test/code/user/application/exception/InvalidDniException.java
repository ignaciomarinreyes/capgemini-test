package com.capgemini.test.code.user.application.exception;

public class InvalidDniException extends RuntimeException {

    public InvalidDniException(String dni) {
        super("El DNI " + dni + " no es válido. No se puede crear el usuario");
    }
}
