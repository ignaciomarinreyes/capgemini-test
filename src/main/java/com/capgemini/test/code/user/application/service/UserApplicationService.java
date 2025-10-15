package com.capgemini.test.code.user.application.service;

import com.capgemini.test.code.user.application.exception.InvalidNameException;
import com.capgemini.test.code.user.application.exception.InvalidUserRoleException;
import com.capgemini.test.code.user.application.port.in.ICreateUserUseCase;
import com.capgemini.test.code.user.application.port.in.IGetUserUseCase;
import com.capgemini.test.code.user.application.port.out.IDniPort;
import com.capgemini.test.code.user.application.port.out.INotificationPort;
import com.capgemini.test.code.user.application.port.out.IRoomPort;
import com.capgemini.test.code.user.application.port.out.IUserPort;
import com.capgemini.test.code.user.domain.enums.UserRol;
import com.capgemini.test.code.user.domain.model.entity.RoomEntity;
import com.capgemini.test.code.user.domain.model.entity.UserEntity;

public class UserApplicationService implements ICreateUserUseCase, IGetUserUseCase {

    private final IUserPort userRepository;
    private final IRoomPort roomRepository;
    private final IDniPort dniPort;
    private final INotificationPort notificationPort;

    public UserApplicationService(IUserPort userRepository, IRoomPort roomRepository, IDniPort dniPort, INotificationPort notificationPort) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.dniPort = dniPort;
        this.notificationPort = notificationPort;
    }

    @Override
    public Long createUser(UserEntity userEntity) {
        validateName(userEntity);
        validateDni(userEntity);
        RoomEntity roomEntity = roomRepository.getRoomById(1L);
        userEntity.setRoom(roomEntity);
        Long idCreatedUser = userRepository.createUser(userEntity);
        if (userEntity.getRol() == UserRol.ADMIN) notificationPort.notifyByEmail();
        else if (userEntity.getRol() == UserRol.SUPERADMIN) notificationPort.notifyBySms();
        else throw new InvalidUserRoleException(userEntity.getRol().name());
        return idCreatedUser;
    }

    private void validateDni(UserEntity userEntity) {
        dniPort.validateDni(userEntity.getDni().getDni());
    }

    private void validateName(UserEntity userEntity) {
        if (userEntity.getName() == null || userEntity.getName().length() > 6) {
            throw new InvalidNameException(userEntity.getName(), "El nombre contiene más de 6 carácteres");
        }
    }

    @Override
    public UserEntity getUser(Long id) {
        return userRepository.getUser(id);
    }
}


