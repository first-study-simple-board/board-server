package com.first.board.dto;

import java.time.LocalDateTime;

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
    private UserEntity user_ID;
    private String title;
    private String p_Content;
    private String post_PW;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PostDTO(PostEntity postEntity){
        this.id = postEntity.getId();
        this.user_ID = postEntity.getUser_ID();
        this.title = postEntity.getTitle();
        this.p_Content = postEntity.getP_Content();
        this.createdDate = postEntity.getCreatedDate();
        this.modifiedDate = postEntity.getModifiedDate();   
    }

    public PostEntity toPostEntity() {
        return new PostEntity(id, title, p_Content, createdDate, user_ID);
    }
}
