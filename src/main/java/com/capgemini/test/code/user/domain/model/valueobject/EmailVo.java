package com.capgemini.test.code.user.domain.model.valueobject;

import com.capgemini.test.code.user.application.exception.InvalidEmailException;

public class EmailVo {

    private final String email;

    public EmailVo(String email) {
        validate(email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void validate(String email) {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailException("El email " + email + " no es válido. No se puede crear el usuario");
        }
    }
}
