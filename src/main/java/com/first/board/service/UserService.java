package com.first.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.first.board.entity.UserEntity;
import com.first.board.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteById(Long user_Index) {
        userRepository.deleteById(user_Index);
    }

    // @Transactional
    // public UserEntity createdUser (UserDTO userDTO) {
    //     return userRepository.save(userDTO.);
    // }
}
