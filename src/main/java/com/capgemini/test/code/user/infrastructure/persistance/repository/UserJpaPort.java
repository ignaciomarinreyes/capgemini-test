package com.capgemini.test.code.user.infrastructure.persistance.repository;

import com.capgemini.test.code.user.application.exception.DniAlreadyExistsException;
import com.capgemini.test.code.user.application.exception.EmailAlreadyExistsException;
import com.capgemini.test.code.user.application.exception.PhoneAlreadyExistsException;
import com.capgemini.test.code.user.application.exception.UserNotFoundException;
import com.capgemini.test.code.user.application.port.out.IUserPort;
import com.capgemini.test.code.user.domain.model.entity.UserEntity;
import com.capgemini.test.code.user.infrastructure.persistance.entity.UserJpaEntity;
import com.capgemini.test.code.user.infrastructure.persistance.mapper.UserJpaEntityMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaPort implements IUserPort {

    private final UserJpaEntityMapper jpaUserEntityMapper;
    private final IUserJpaRepository userJpaRepository;

    public UserJpaPort(IUserJpaRepository jpaUserRepository, UserJpaEntityMapper jpaUserEntityMapper) {
        this.jpaUserEntityMapper = jpaUserEntityMapper;
        this.userJpaRepository = jpaUserRepository;
    }

    @Override
    public Long createUser(UserEntity userEntity) {
        UserJpaEntity userJpaEntity = jpaUserEntityMapper.toJpaEntity(userEntity);
        UserJpaEntity savedUserJpaEntity = null;
        try {
            savedUserJpaEntity = userJpaRepository.save(userJpaEntity);
        } catch (DataIntegrityViolationException exception) {
            if (exception.getMessage().contains("Key (dni)")) throw new DniAlreadyExistsException(userJpaEntity.getDni());
            else if (exception.getMessage().contains("Key (email)")) throw new EmailAlreadyExistsException(userJpaEntity.getEmail());
            else if (exception.getMessage().contains("Key (phone)")) throw new PhoneAlreadyExistsException(userJpaEntity.getPhone());
            else throw exception;
        }
        return savedUserJpaEntity.getId();
    }

    @Override
    public UserEntity getUser(Long id, Integer idRoom) {
        return jpaUserEntityMapper.toUserEntity(userJpaRepository.findByIdAndRoomId(id, idRoom).orElseThrow(() ->
                new UserNotFoundException(id)
        ));
    }
}
