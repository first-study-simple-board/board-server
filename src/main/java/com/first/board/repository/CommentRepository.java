package com.first.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.board.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    
}
