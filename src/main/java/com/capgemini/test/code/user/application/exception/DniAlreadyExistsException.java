package com.capgemini.test.code.user.application.exception;

public class DniAlreadyExistsException extends RuntimeException{

    public DniAlreadyExistsException(String dni) {
        super("El DNI " + dni + " ya existe. No se puede crear el usuario");
    }
}
