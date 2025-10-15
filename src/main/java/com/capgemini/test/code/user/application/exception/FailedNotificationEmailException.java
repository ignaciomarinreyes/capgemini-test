package com.capgemini.test.code.user.application.exception;

public class FailedNotificationEmailException extends RuntimeException {
    public FailedNotificationEmailException() {
        super("Fallo la notificación por email");
    }
}
