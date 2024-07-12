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
    private PostEntity postEntity;
    private UserEntity userEntity;
    private String content;
    private String comment_Type;
    private LocalDateTime createdDate;

    public CommentDTO(CommentEntity commentEntity){
        this.id = commentEntity.getId();
        this.postEntity = commentEntity.getPostEntity();
        this.userEntity = commentEntity.getUserEntity();
        this.content = commentEntity.getContent();
        this.createdDate = commentEntity.getCreatedDate();
    }

    public CommentEntity toCommentEntity() {
        return new CommentEntity(id, content, createdDate, userEntity, postEntity);
    }

}
