package com.capgemini.test.code.user.application.exception;

public class FailedNotificationSmsException extends RuntimeException {
    public FailedNotificationSmsException() {
        super("Fallo la notificación por SMS");
    }
}
