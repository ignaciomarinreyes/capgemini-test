package com.capgemini.test.code.user.application.exception;

public class InvalidNameException extends RuntimeException{

    public InvalidNameException(String name, String motivo) {
        super("El nombre " + name + " no es válido. " + motivo + ".");
    }
}
