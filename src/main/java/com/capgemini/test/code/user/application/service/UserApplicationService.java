package com.capgemini.test.code.user.application.service;

import com.capgemini.test.code.user.application.exception.InvalidNameException;
import com.capgemini.test.code.user.application.port.in.ICreateUserUseCase;
import com.capgemini.test.code.user.application.port.in.IGetUserUseCase;
import com.capgemini.test.code.user.application.port.out.IDniPort;
import com.capgemini.test.code.user.application.port.out.IRoomPort;
import com.capgemini.test.code.user.application.port.out.IUserPort;
import com.capgemini.test.code.user.domain.model.entity.RoomEntity;
import com.capgemini.test.code.user.domain.model.entity.UserEntity;

public class UserApplicationService implements ICreateUserUseCase, IGetUserUseCase {

    private final IUserPort userRepository;
    private final IRoomPort roomRepository;
    private final IDniPort dniPort;

    public UserApplicationService(IUserPort userRepository, IRoomPort roomRepository, IDniPort dniPort) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.dniPort = dniPort;
    }

    @Override
    public Long createUser(UserEntity userEntity) {
        validateName(userEntity);
        validateDni(userEntity);
        RoomEntity roomEntity = roomRepository.getRoomById(1L);
        userEntity.setRoom(roomEntity);
        return userRepository.createUser(userEntity);
    }

    private void validateDni(UserEntity userEntity) {
        dniPort.validateDni(userEntity.getDni().getDni());
    }

    private void validateName(UserEntity userEntity) {
        if (userEntity.getName() == null || userEntity.getName().length() > 6) {
            throw new InvalidNameException("El nombre " + userEntity.getName() + " no es válido. El nombre contiene más de 6 carácteres.");
        }
    }

}


