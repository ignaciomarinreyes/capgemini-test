package com.capgemini.test.code.user.application.port.out;

import com.capgemini.test.code.user.domain.model.entity.RoomEntity;


public interface IRoomPort {

    RoomEntity getRoomById(Long id);
}
