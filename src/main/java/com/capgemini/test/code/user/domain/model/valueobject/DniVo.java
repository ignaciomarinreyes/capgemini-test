package com.capgemini.test.code.user.domain.model.valueobject;

import com.capgemini.test.code.user.application.exception.InvalidDniException;

public class DniVo {

    private String dni;

    public DniVo(String dni) {
        validate(dni);
        this.dni = dni;
    }

    private void validate(String dni) {
        if (dni == null || !dni.matches("\\d{8}[A-Z]")) {
            throw new InvalidDniException("El DNI " + dni + " no es válido. No se puede crear el usuario");
        }
    }

    public String getDni() {
        return dni;
    }
}
