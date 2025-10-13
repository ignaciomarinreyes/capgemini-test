package com.capgemini.test.code.user.infrastructure.service;

import com.capgemini.test.code.user.application.port.in.ICreateUserUseCase;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserIdResponse;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserRequest;
import com.capgemini.test.code.user.infrastructure.service.mapper.UserInfrastructureServiceMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserInfrastructureService {

    private final ICreateUserUseCase createUserUseCase;
    private final UserInfrastructureServiceMapper userInfrastructureServiceMapper;

    public UserInfrastructureService(ICreateUserUseCase createUserUseCase, UserInfrastructureServiceMapper userInfrastructureServiceMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userInfrastructureServiceMapper = userInfrastructureServiceMapper;
    }

    @Transactional
    public UserIdResponse createUser(UserRequest userRequest) {
        return userInfrastructureServiceMapper.toUserIdResponse(createUserUseCase.createUser(userInfrastructureServiceMapper.toEntity(userRequest)));
    }
}
