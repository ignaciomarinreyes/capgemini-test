package com.capgemini.test.code.user.infrastructure.service;

import com.capgemini.test.code.user.application.exception.FailedNotificationEmailException;
import com.capgemini.test.code.user.application.exception.FailedNotificationSmsException;
import com.capgemini.test.code.user.application.port.out.INotificationPort;
import com.capgemini.test.code.user.infrastructure.controller.dto.NotificationRequest;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationClient implements INotificationPort {

    private static final Logger logger = LoggerFactory.getLogger(NotificationClient.class);

    private final INotificationClient notificationClient;
    private final String mensajeNotificacion = "usuario guardado";

    public NotificationClient(INotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    @Override
    public void notifyByEmail() {
        NotificationRequest notificationRequest = new NotificationRequest();
        try {
            notificationClient.notifyByEmail(notificationRequest);
            logger.info(mensajeNotificacion);
        } catch (FeignException exception) {
            throw new FailedNotificationEmailException();
        }
    }

    @Override
    public void notifyBySms() {
        NotificationRequest notificationRequest = new NotificationRequest();
        try {
            notificationClient.notifyBySms(notificationRequest);
            logger.info(mensajeNotificacion);
        } catch (FeignException exception) {
            throw new FailedNotificationSmsException();
        }
    }
}
