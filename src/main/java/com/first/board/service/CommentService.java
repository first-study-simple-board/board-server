package com.first.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.first.board.dto.CommentDTO;
import com.first.board.entity.CommentEntity;
import com.first.board.repository.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public List<CommentEntity> getAllComment() {
        return commentRepository.findAll();
    }

    @Transactional
    public void deleteByCommentID (Long comment_ID) {
        commentRepository.deleteById(comment_ID);
    }

    @Transactional
    public CommentEntity createdComment (CommentDTO commentDTO) {
        return commentRepository.save(commentDTO.toCommentEntity());
    }

}
