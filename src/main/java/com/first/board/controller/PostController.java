package com.first.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.dto.PostDTO;
import com.first.board.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPost() {
        List<PostDTO> posts = postService.getAllPost();
        return ResponseEntity.ok(posts);
    }
    
    @GetMapping("/{id}")
    public void deletePost(@PathVariable Long post_ID) {
        postService.deleteByPostID(post_ID);
    }
}
