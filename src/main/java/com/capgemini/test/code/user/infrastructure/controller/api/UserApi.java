package com.capgemini.test.code.user.infrastructure.controller.api;

import com.capgemini.test.code.user.infrastructure.controller.dto.UserIdResponse;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserApi {

    ResponseEntity<UserIdResponse> createUser(UserRequest userRequest);

    ResponseEntity<UserResponse> getUser(@PathVariable Long id);
}
