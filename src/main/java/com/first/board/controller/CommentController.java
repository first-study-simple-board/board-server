package com.first.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.dto.CommentDTO;
import com.first.board.service.CommentService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "comments", description = "댓글 API")
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDTO> getAllComment() {
        return commentService.getAllComments();
    }
    
    @PutMapping("/{id}")
    public CommentDTO updateComment(@PathVariable("comment_ID") Long id, @RequestBody CommentDTO commentDTO) {
        return commentService.updatedComment(id, commentDTO);
    }

    @PostMapping()
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createdComment(commentDTO);
    }

    @GetMapping("/{id}")
    public void deleteComment (@PathVariable Long comment_ID) {
        commentService.deleteByCommentID(comment_ID);
    }
    

}
