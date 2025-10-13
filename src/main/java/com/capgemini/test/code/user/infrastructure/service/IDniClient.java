package com.capgemini.test.code.user.infrastructure.service;

import com.capgemini.test.code.user.infrastructure.controller.dto.CheckDniRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.CheckDniResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "checkDniClient", url = "${external.service.url}")
public interface IDniClient {

  @PostMapping("/check-dni")
  ResponseEntity<CheckDniResponse> check(@RequestBody CheckDniRequest request);
}
