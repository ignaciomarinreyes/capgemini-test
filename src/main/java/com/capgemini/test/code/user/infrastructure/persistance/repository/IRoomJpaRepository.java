package com.capgemini.test.code.user.infrastructure.persistance.repository;

import com.capgemini.test.code.user.infrastructure.persistance.entity.RoomJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRoomJpaRepository extends JpaRepository<RoomJpaEntity, Long> {
}
