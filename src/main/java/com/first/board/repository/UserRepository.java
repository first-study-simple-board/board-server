package com.first.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.board.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
