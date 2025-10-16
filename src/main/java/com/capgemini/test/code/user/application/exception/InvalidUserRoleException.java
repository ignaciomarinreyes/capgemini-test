package com.capgemini.test.code.user.application.exception;

public class InvalidUserRoleException extends RuntimeException {
    public InvalidUserRoleException(String nombreRol) {
        super("El rol " + nombreRol + " no es válido. Tiene que ser ADMIN o SUPERADMIN");
    }
}
