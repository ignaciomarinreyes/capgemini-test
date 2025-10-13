package com.capgemini.test.code.user.infrastructure.controller.api;

import com.capgemini.test.code.user.infrastructure.controller.dto.UserIdResponse;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserRequest;
import org.springframework.http.ResponseEntity;

public interface UserApi {

    ResponseEntity<UserIdResponse> createUser(UserRequest userRequest);
}
