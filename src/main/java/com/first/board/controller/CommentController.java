package com.first.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.dto.CommentDTO;
import com.first.board.entity.PostEntity;
import com.first.board.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
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


    // @Operation(summary = "all comments", description = "모든 댓글을 반환하는 메소드")
    // @GetMapping
    // public List<CommentDTO> getAllComment() {
    //     return commentService.getAllComments();
    // }
    
    @Operation(summary = "find comment", description = "글 ID로 찾는 메소드") 
    @GetMapping("/{id}")
    public CommentDTO findComment(@PathVariable("post_ID") PostEntity id) {
        return commentService.getCommentByPostID(id);
    }

    @Operation(summary = "update comment", description = "댓글을 변경하는 메소드")
    @PutMapping("/{id}")
    public CommentDTO updateComment(@PathVariable("comment_ID") Long id, @RequestBody CommentDTO commentDTO) {
        return commentService.updatedComment(id, commentDTO);
    }

    @Operation(summary = "create comment", description = "새로운 댓글을 저장하는 메소드")
    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createdComment(commentDTO);
    }

    @Operation(summary = "delete comment", description = "댓글을 삭제하는 메소드")
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long comment_ID) {
        commentService.deleteByCommentID(comment_ID);
    }

}
