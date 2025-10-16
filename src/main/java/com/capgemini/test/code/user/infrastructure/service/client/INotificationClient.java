package com.capgemini.test.code.user.infrastructure.service.client;

import com.capgemini.test.code.user.infrastructure.controller.dto.EmailNotificationRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.SmsNotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificationClient", url = "${external.service.url}")
public interface INotificationClient {

    @PostMapping("/sms")
    ResponseEntity<Void> notifyBySms(@RequestBody SmsNotificationRequest request);

    @PostMapping("/email")
    ResponseEntity<Void> notifyByEmail(@RequestBody EmailNotificationRequest request);
}
