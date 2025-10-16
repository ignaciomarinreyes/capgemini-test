package com.capgemini.test.code.user.infrastructure.persistance.mapper;

import com.capgemini.test.code.user.domain.model.entity.UserEntity;
import com.capgemini.test.code.user.domain.model.valueobject.DniVo;
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
        return UserJpaEntity.builder()
                .dni(userEntity.getDni().getDni())
                .rol(userEntity.getRol())
                .phone(userEntity.getPhone())
                .name(userEntity.getName())
                .room(roomJpaEntityMapper.toJpaEntity(userEntity.getRoom()))
                .email(userEntity.getEmail().getEmail())
                .build();
    }

    public UserEntity toUserEntity(UserJpaEntity userJpaEntity) {
        return new UserEntity(
                userJpaEntity.getId(),
                userJpaEntity.getName(),
                new EmailVo(userJpaEntity.getEmail()),
                userJpaEntity.getPhone(),
                userJpaEntity.getRol(),
                new DniVo(userJpaEntity.getDni()),
                roomJpaEntityMapper.toEntity(userJpaEntity.getRoom())
        );
    }
}
