package com.capgemini.test.code.user.application.port.out;

public interface INotificationPort {

    void notifyByEmail(String email);
    void notifyBySms(String phone);
}
