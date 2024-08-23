package com.first.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.board.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByUseFlag(boolean useFlag);

}
