package com.first.board.dto;

import java.time.LocalDateTime;

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
public class PostDTO {
    private Long post_ID;
    private UserEntity user_ID;
    private String title;
    private String p_Content;
    private String post_PW;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PostDTO(PostEntity postEntity){
        this.post_ID = postEntity.getPost_ID();
        this.user_ID = postEntity.getUser_ID();
        this.title = postEntity.getTitle();
        this.p_Content = postEntity.getP_Content();
        this.post_PW = postEntity.getPost_PW();
        this.createdDate = postEntity.getCreatedDate();
        this.modifiedDate = postEntity.getModifiedDate();   
    }

    public PostEntity toPostEntity() {
        return new PostEntity(user_ID, title, p_Content, post_PW);
    }
}
