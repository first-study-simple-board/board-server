package com.first.board.dto;

import java.time.LocalDateTime;

import com.first.board.entity.PostEntity;

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
    private Long user;
    private String title;
    private String p_Content;
    private String post_PW;
    private boolean useFlag;
    private LocalDateTime post_createdDate;
    private LocalDateTime post_modifiedDate;

    public PostDTO(PostEntity postEntity){
        this.id = postEntity.getPostId();
        this.user = postEntity.getUser();
        this.title = postEntity.getTitle();
        this.p_Content = postEntity.getContent();
        this.post_createdDate = postEntity.getPost_createdDate();
        this.post_modifiedDate = postEntity.getPost_modifiedDate();
    }

    public PostEntity toPostEntity() {
        return new PostEntity(id, title, p_Content, post_createdDate, user, useFlag);
    }
}
