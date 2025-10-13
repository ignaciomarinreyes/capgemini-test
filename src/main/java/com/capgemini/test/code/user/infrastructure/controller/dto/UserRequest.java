package com.capgemini.test.code.user.infrastructure.controller.dto;

public record UserRequest(
        String name,
        String email,
        String phone,
        String rol,
        String dni
    ){
}
