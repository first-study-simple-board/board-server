package com.first.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.board.dto.CommentDTO;
import com.first.board.entity.CommentEntity;
import com.first.board.repository.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

  @Transactional
    public List<CommentDTO> getAllComments(){
        List<CommentEntity> comments = commentRepository.findAll();
        return comments.stream()
                    .map(CommentEntity -> modelMapper.map(CommentEntity, CommentDTO.class))
                    .collect(Collectors.toList());
    }

    @Transactional
    public CommentDTO getCommentByCommentId (Long comment_ID) {
        CommentEntity commentEntity = commentRepository.findById(comment_ID).orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
        return modelMapper.map(commentEntity, CommentDTO.class);
    }

    @Transactional
    public CommentDTO createdComment (CommentDTO commentDTO) {
        CommentEntity commentEntity = modelMapper.map(commentDTO, CommentEntity.class);
        CommentEntity saveComment = commentRepository.save(commentEntity);
        return modelMapper.map(saveComment, CommentDTO.class);
    }

    @Transactional
    public CommentDTO updatedComment(Long comment_ID, CommentDTO commentDTO) {
        CommentEntity commentEntity = commentRepository.findById(comment_ID)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
                commentEntity.update(commentDTO.getContent());
        CommentEntity updatedComment = commentRepository.save(commentEntity);
        return modelMapper.map(updatedComment, CommentDTO.class);
    }

    @Transactional
    public void deleteByCommentID (Long comment_ID) {
        commentRepository.deleteById(comment_ID);
    }

}
