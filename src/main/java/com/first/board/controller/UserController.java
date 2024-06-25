package com.first.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.entity.UserEntity;
import com.first.board.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public void deleteUser(@PathVariable Long user_Index) {
        userService.deleteById(user_Index);
    }
}
