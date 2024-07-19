package com.first.board.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.first.board.entity.PostEntity;
import com.first.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PostDTO {
    private Long id;
    // private UserEntity userEntity;
    @JsonIgnore
    private UserEntity author;
    private String title;
    private String content;
    private boolean useFlag;
    private LocalDateTime created_at ;
    private LocalDateTime updated_at;

    public PostDTO(PostEntity postEntity){
        this.id = postEntity.getPostId();
        this.author = postEntity.getUser();
        this.title = postEntity.getTitle();
        this.created_at  = postEntity.getPost_createdDate();
        this.updated_at = postEntity.getPost_modifiedDate();
    }

    public PostEntity toPostEntity() {
        return new PostEntity(id, title, content, created_at , author, useFlag);
    }
}
