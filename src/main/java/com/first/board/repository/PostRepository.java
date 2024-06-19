package com.first.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.board.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
