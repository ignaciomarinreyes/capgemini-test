package com.capgemini.test.code.user.application.exception;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(Long id) {
        super("La sala " + id + " no existe");
    }
}
