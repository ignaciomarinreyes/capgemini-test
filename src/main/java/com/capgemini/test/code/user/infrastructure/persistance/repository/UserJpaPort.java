package com.capgemini.test.code.user.infrastructure.persistance.repository;

import com.capgemini.test.code.user.application.exception.EmailAlreadyExistsException;
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
            throw new EmailAlreadyExistsException(userJpaEntity.getEmail());
        }
        return savedUserJpaEntity.getId();
    }

    @Override
    public UserEntity getUser(Long id) {
        return jpaUserEntityMapper.toUserEntity(userJpaRepository.findByIdAndRoomId(id, 1).orElseThrow(() ->
                new UserNotFoundException(id)
        ));
    }
}
