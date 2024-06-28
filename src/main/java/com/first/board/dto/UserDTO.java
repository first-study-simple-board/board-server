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
    private Long id;
    private String account;
    private String user_PW;
    private String user_NickName;
    private String logintype;
    private LocalDateTime createdDate;

    //Entity와 연결
    public UserDTO(UserEntity userEntity) {
        this.account = userEntity.getAccount();
        this.id = userEntity.getId();
        this.user_PW = userEntity.getUser_PW();
        this.user_NickName = userEntity.getUser_NickName();
        this.logintype = userEntity.getLoginType();
        this.createdDate = userEntity.getCreatedDate();
    }
}
