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
    private Long comment_ID;
    private PostEntity post_ID;
    private UserEntity user_ID;
    private String c_Comment;
    private String comment_Type;
    private LocalDateTime createdDate;

    public CommentDTO(CommentEntity commentEntity){
        this.comment_ID = commentEntity.getComment_ID();
        this.post_ID = commentEntity.getPost_ID();
        this.user_ID = commentEntity.getUser_ID();
        this.c_Comment = commentEntity.getC_Comment();
        this.comment_Type = commentEntity.getComment_Type();
        this.createdDate = commentEntity.getCreatedDate();
    }

    public CommentEntity toCommentEntity() {
        return new CommentEntity(post_ID, user_ID, c_Comment, comment_Type);
    }

}
