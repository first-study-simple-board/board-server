package com.first.board.dto;

import java.time.LocalDateTime;

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
    private PostEntity post_ID;
    private UserEntity user_ID;
    private String content;
    private String comment_Type;
    private LocalDateTime createdDate;

    public CommentDTO(CommentEntity commentEntity){
        this.id = commentEntity.getId();
        this.post_ID = commentEntity.getPost_ID();
        this.user_ID = commentEntity.getUser_ID();
        this.content = commentEntity.getContent();
        this.createdDate = commentEntity.getCreatedDate();
    }

    public CommentEntity toCommentEntity() {
        return new CommentEntity(id, content, createdDate, user_ID, post_ID);
    }

}
