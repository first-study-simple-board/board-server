package com.first.board.dto;

import java.time.LocalDateTime;

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
public class UserDTO {
    private Long id;
    private String account;
    private String user_PW;
    private String name;
    private String logintype;
    private LocalDateTime createdDate;

    //Entity와 연결
    // public UserDTO(UserEntity userEntity) {
    //     this.account = userEntity.getAccount();
    //     this.id = userEntity.getId();
    //     this.user_PW = userEntity.getUser_PW();
    //     this.name = userEntity.getUser_Name();
    //     this.logintype = userEntity.getLoginType();
    //     this.createdDate = userEntity.getCreatedDate();
    // }
    public UserDTO(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getUser_Name();
    }

}
