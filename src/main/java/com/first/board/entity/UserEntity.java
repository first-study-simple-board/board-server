package com.first.board.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_Index;

    @Column(name = "USER_ID")
    private String user_ID;

    @Column(name = "USER_PW")
    private String user_PW;

    @Column(name = "USER_NAME")
    private String user_Name;

    @Column(name = "LOGINTYPE")
    private String loginType;

    @CreatedDate
    @Column(updatable=false, name = "CREATED_DATE" )
    private LocalDateTime createdDate;

    public UserEntity (String user_ID, String user_PW, String user_Name, String loginType) {
        this.user_ID = user_ID;
        this.user_PW = user_PW;
        this.user_Name = user_Name;
        this.loginType = loginType;
    }
}
