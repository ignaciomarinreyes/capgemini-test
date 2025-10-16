package com.capgemini.test.code.user.application.exception;

public class PhoneAlreadyExistsException extends RuntimeException{

    public PhoneAlreadyExistsException(String phone) {
        super("El teléfono " + phone + " ya existe. No se puede crear el usuario");
    }
}
