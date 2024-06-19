package com.first.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTO {
    private String user_ID;
    private String user_PW;
    private String user_Name;
    private String logintype;
    private LocalDateTime createdDate;
}
