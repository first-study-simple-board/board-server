package com.first.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.dto.UserDTO;
import com.first.board.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "users", description = "유저 API")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "all users", description = "모든 유저들을 반환하는 메소드")
    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @Operation(summary = "find user", description = "유저 ID로 찾는 메소드")
    @GetMapping("/{id}")
    public UserDTO findUser(@PathVariable("id") Long id) {
        return userService.getUserByID(id);
    }

    @Operation(summary = "update user", description = "유저 정보를 변경하는 메소드")
    @PutMapping("/{id}")
    public UserDTO updateUser (@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        return userService.updatedUser(id, userDTO);
    }

    @Operation(summary = "create user", description = "새로운 유저를 저장하는 메소드")
    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createdUser(userDTO);
    }

    @Operation(summary = "delete user", description = "유저를 삭제하는 메소드")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
