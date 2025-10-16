package com.capgemini.test.code.user.infrastructure.persistance.repository;

import com.capgemini.test.code.user.application.exception.RoomNotFoundException;
import com.capgemini.test.code.user.application.port.out.IRoomPort;
import com.capgemini.test.code.user.domain.model.entity.RoomEntity;
import com.capgemini.test.code.user.infrastructure.persistance.mapper.RoomJpaEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoomJpaPort implements IRoomPort {

    private final IRoomJpaRepository roomJpaRepository;
    private final RoomJpaEntityMapper roomJpaEntityMapper;

    public RoomJpaPort(IRoomJpaRepository roomJpaRepository, RoomJpaEntityMapper roomJpaEntityMapper) {
        this.roomJpaRepository = roomJpaRepository;
        this.roomJpaEntityMapper = roomJpaEntityMapper;
    }

    @Override
    public RoomEntity getRoomById(Long id) {
        return roomJpaEntityMapper.toEntity(roomJpaRepository.findById(id).orElseThrow(() ->
                new RoomNotFoundException(id)
        ));
    }
}
