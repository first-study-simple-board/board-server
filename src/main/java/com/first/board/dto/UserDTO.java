package com.first.board.dto;

import java.time.LocalDateTime;

import com.first.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {
    private Long user_Index;
    private String user_ID;
    private String user_PW;
    private String user_Name;
    private String logintype;
    private LocalDateTime createdDate;

    //Entity와 연결
    public UserDTO(UserEntity userEntity) {
        this.user_Index = userEntity.getUser_Index();
        this.user_ID = userEntity.getUser_ID();
        this.user_PW = userEntity.getUser_PW();
        this.user_Name = userEntity.getUser_Name();
        this.logintype = userEntity.getLoginType();
        this.createdDate = userEntity.getCreatedDate();
    }

    public UserEntity toUserEntity() {
        return new UserEntity(user_ID, user_PW, user_Name, logintype);
    }
}
