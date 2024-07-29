package com.first.board.component;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.first.board.entity.PostEntity;
import com.first.board.entity.UserEntity;
import com.first.board.repository.PostRepository;
import com.first.board.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Component
public class PostDataLoader {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public PostDataLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {

        
        UserEntity user1 = new UserEntity(null, "1234", "User 1", "A", LocalDateTime.now());
        UserEntity user2 = new UserEntity(null, "1234", "User 2", "A", LocalDateTime.now());
        UserEntity user3 = new UserEntity(null, "1234", "User 3", "A", LocalDateTime.now());

        // UserEntity를 먼저 저장해야 할 수도 있습니다
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        postRepository.save(new PostEntity(null, "Title 1", "Content 1", LocalDateTime.now(), user1, true));
        postRepository.save(new PostEntity(null, "Title 2", "Content 2", LocalDateTime.now(), user2, true));
        postRepository.save(new PostEntity(null, "Title 3", "Content 3", LocalDateTime.now(), user3, true));
    }

}
