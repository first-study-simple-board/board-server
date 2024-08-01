package com.first.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.board.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByRefreshToken(String refreshToken);
}
