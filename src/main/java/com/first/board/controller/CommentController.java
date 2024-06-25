package com.first.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.entity.CommentEntity;
import com.first.board.service.CommentService;


@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentEntity> getAllComment() {
        return commentService.getAllComment();
    }
    
    @GetMapping("/{id}")
    public void deleteComment (@PathVariable Long comment_ID) {
        commentService.deleteByCommentID(comment_ID);
    }
    

}
