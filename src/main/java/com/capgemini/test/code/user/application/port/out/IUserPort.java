package com.capgemini.test.code.user.application.port.out;

import com.capgemini.test.code.user.domain.model.entity.UserEntity;

public interface IUserPort {

    Long createUser(UserEntity userEntity);
}
