package com.capgemini.test.code.user.infrastructure.controller.dto;

public record UserResponse(
    String name,
    String email,
    String phone,
    String rol
) {

}
