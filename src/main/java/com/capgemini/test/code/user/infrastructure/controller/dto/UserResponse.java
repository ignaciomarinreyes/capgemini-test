package com.capgemini.test.code.user.infrastructure.controller.dto;

public record UserResponse(
    Long id,
    String name,
    String email,
    String dni,
    String phone,
    String rol,
    Long idRoom
) {

}
