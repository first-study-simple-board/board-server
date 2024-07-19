package com.first.board.dto;

import java.time.LocalDateTime;

import com.first.board.entity.CommentEntity;

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
    private Long post;
    private String content;
    private String comment_Type;
    private LocalDateTime createdDate;

    public CommentDTO(CommentEntity commentEntity){
        this.id = commentEntity.getCommentId();
        this.post = commentEntity.getPostId();
        this.content = commentEntity.getContent();
        this.createdDate = commentEntity.getCreatedDate();
    }

    public CommentEntity toCommentEntity() {
        return new CommentEntity(id, content, createdDate, post);
    }

}
