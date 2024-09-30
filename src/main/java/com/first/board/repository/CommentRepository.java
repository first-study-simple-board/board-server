package com.first.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.board.entity.CommentEntity;
import com.first.board.entity.PostEntity;


public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    public Optional<CommentEntity> findByPostId(PostEntity postId);
    
}
