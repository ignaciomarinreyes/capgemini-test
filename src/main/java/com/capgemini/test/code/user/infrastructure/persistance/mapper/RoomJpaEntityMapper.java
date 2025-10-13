package com.capgemini.test.code.user.infrastructure.persistance.mapper;

import com.capgemini.test.code.user.domain.model.entity.RoomEntity;
import com.capgemini.test.code.user.infrastructure.persistance.entity.RoomJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class RoomJpaEntityMapper {

    public RoomJpaEntity toJpaEntity(RoomEntity room) {
        return new RoomJpaEntity(
            room.id(),
            room.name()
        );
    }

    public RoomEntity toEntity(RoomJpaEntity room) {
        return new RoomEntity(
                room.getId(),
                room.getName()
        );
    }
}
