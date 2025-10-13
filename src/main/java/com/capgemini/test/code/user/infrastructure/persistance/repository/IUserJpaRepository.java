package com.capgemini.test.code.user.infrastructure.persistance.repository;

import com.capgemini.test.code.user.infrastructure.persistance.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
}
