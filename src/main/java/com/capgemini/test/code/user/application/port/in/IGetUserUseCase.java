package com.capgemini.test.code.user.application.port.in;

import com.capgemini.test.code.user.domain.model.entity.UserEntity;

public interface IGetUserUseCase {
    UserEntity getUser(Long id);
}
