package com.first.board.component;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.first.board.entity.PostEntity;
import com.first.board.repository.PostRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Component
public class PostDataLoader {
    private final PostRepository postRepository;

    public PostDataLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @PostConstruct
    @Transactional
    public void init() {
        postRepository.save(new PostEntity(1L, "Title 1", "Content 1", LocalDateTime.now(), 1L, true));
        postRepository.save(new PostEntity(2L, "Title 2", "Content 2", LocalDateTime.now(), 2L, true));
        postRepository.save(new PostEntity(3L, "Title 3", "Content 3", LocalDateTime.now(), 3L, true));
    }

}
