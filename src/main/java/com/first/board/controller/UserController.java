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

    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @PutMapping("/{id}")
    public UserDTO updateUser (@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        return userService.updatedUser(id, userDTO);
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createdUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
