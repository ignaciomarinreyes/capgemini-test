package com.capgemini.test.code.user.infrastructure.persistance.mapper;

import com.capgemini.test.code.user.domain.model.entity.UserEntity;
import com.capgemini.test.code.user.domain.model.valueobject.EmailVo;
import com.capgemini.test.code.user.infrastructure.persistance.entity.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UserJpaEntityMapper {

    private RoomJpaEntityMapper roomJpaEntityMapper;

    public UserJpaEntityMapper(RoomJpaEntityMapper roomJpaEntityMapper) {
        this.roomJpaEntityMapper = roomJpaEntityMapper;
    }

    public UserJpaEntity toJpaEntity(UserEntity userEntity) {
        return new UserJpaEntity(
             userEntity.getName(),
             userEntity.getEmail().getEmail(),
             userEntity.getRol(),
             roomJpaEntityMapper.toJpaEntity(userEntity.getRoom())
        );
    }
}
