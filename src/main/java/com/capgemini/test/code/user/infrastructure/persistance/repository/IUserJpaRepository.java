package com.capgemini.test.code.user.infrastructure.persistance.repository;

import com.capgemini.test.code.user.infrastructure.persistance.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IUserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
    Optional<UserJpaEntity> findByIdAndRoomId(Long id, int i);
}
