package com.capgemini.test.code.user.infrastructure.service;

import com.capgemini.test.code.user.infrastructure.controller.dto.NotificationRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificationClient", url = "${external.service.url}")
public interface INotificationClient {

    @PostMapping("/sms")
    ResponseEntity<NotificationResponse> notifyBySms(@RequestBody NotificationRequest request);

    @PostMapping("/email")
    ResponseEntity<NotificationResponse> notifyByEmail(@RequestBody NotificationRequest request);
}
