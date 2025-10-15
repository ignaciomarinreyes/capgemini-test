package com.capgemini.test.code.user.infrastructure.service.mapper;

import com.capgemini.test.code.user.domain.model.entity.UserEntity;
import com.capgemini.test.code.user.domain.model.valueobject.DniVo;
import com.capgemini.test.code.user.domain.model.valueobject.EmailVo;
import com.capgemini.test.code.user.infrastructure.controller.dto.CheckDniRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserIdResponse;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserInfrastructureServiceMapper {

    public UserEntity toEntity(UserRequest userRequest) {
        return new UserEntity(
            userRequest.name(),
            new EmailVo(userRequest.email()),
            userRequest.phone(),
            userRequest.rol().toUpperCase(),
            new DniVo(userRequest.dni())
        );
    }

    public UserIdResponse toUserIdResponse(Long user) {
        return new UserIdResponse(
           user
        );
    }

    public CheckDniRequest toCheckDniRequest(String dni) {
        return new CheckDniRequest(
                dni
        );
    }

    public UserResponse toUserResponse(UserEntity user) {
        return new UserResponse(
                user.getName(),
                user.getEmail().getEmail(),
                user.getPhone(),
                user.getRol().name()
        );
    }
}
