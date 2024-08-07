package com.first.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.dto.PostDTO;
import com.first.board.service.PostService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "posts", description = "게시물 API")
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public List<PostDTO> getAllPosts() {
        return postService.getAllPost();
    }

    @GetMapping()
    public List<PostDTO> getTruePost() {
        return postService.getAllPost();
    }

    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable("id") Long id, @RequestBody PostDTO postDTO) {
        return postService.updatedpost(id, postDTO);
    }

    @PostMapping()
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return postService.createdPost(postDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id")Long id, @RequestBody PostDTO postDTO) {
        postService.deleteByPostID(id, postDTO);
    }
}
