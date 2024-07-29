package com.first.board.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.first.board.entity.CommentEntity;
import com.first.board.entity.PostEntity;
import com.first.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentDTO {
    private Long id;
    @JsonIgnore
    private PostEntity post;
    private String content;
    private String comment_Type;
    private LocalDateTime created_at;
    private UserEntity author;

    public CommentDTO(CommentEntity commentEntity){
        this.id = commentEntity.getCommentId();
        this.content = commentEntity.getContent();
        this.created_at = commentEntity.getCreatedDate();
        this.author = commentEntity.getUserId();
    }

}
