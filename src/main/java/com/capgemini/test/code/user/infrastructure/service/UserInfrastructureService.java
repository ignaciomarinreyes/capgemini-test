package com.capgemini.test.code.user.infrastructure.service;

import com.capgemini.test.code.user.application.port.in.ICreateUserUseCase;
import com.capgemini.test.code.user.application.port.in.IGetUserUseCase;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserIdResponse;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.UserResponse;
import com.capgemini.test.code.user.infrastructure.service.mapper.UserInfrastructureServiceMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserInfrastructureService {

    private final ICreateUserUseCase createUserUseCase;
    private final IGetUserUseCase getUserUseCase;
    private final UserInfrastructureServiceMapper userInfrastructureServiceMapper;

    public UserInfrastructureService(ICreateUserUseCase createUserUseCase, IGetUserUseCase getUserUseCase, UserInfrastructureServiceMapper userInfrastructureServiceMapper) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.userInfrastructureServiceMapper = userInfrastructureServiceMapper;
    }

    @Transactional
    public UserIdResponse createUser(UserRequest userRequest) {
        return userInfrastructureServiceMapper.toUserIdResponse(createUserUseCase.createUser(userInfrastructureServiceMapper.toEntity(userRequest)));
    }

    public UserResponse getUser(Long id) {
        return userInfrastructureServiceMapper.toUserResponse(getUserUseCase.getUser(id));
    }
}
