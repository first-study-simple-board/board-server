package com.first.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.board.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    // @Query("SELECT p FROM post p WHERE p.useFlag = :useFlag")
    // List<PostEntity> findByUseFlag(@Param("useFlag") boolean useFlag);

    List<PostEntity> findByUseFlag(boolean useFlag);

}
