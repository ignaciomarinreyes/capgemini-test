package com.capgemini.test.code.user.infrastructure.controller;

import com.capgemini.test.code.user.infrastructure.controller.api.UserApi;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserIdResponse;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserRequest;
import com.capgemini.test.code.user.infrastructure.service.UserInfrastructureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi {

    private final UserInfrastructureService userInfrastructureService;

    public UserController(UserInfrastructureService userInfrastructureService) {
        this.userInfrastructureService = userInfrastructureService;
    }

    @Override
    @PostMapping
    public ResponseEntity<UserIdResponse> createUser(@RequestBody UserRequest userRequest) {
        UserIdResponse userIdResponse = userInfrastructureService.createUser(userRequest);
        return ResponseEntity
                .status(201)
                .body(userIdResponse);
    }
}
