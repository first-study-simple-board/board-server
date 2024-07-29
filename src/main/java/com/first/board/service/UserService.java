package com.first.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.first.board.dto.UserDTO;
import com.first.board.entity.UserEntity;
import com.first.board.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService (UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<UserDTO> getAllUser() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                    .map(UserEntity -> modelMapper.map(UserEntity, UserDTO.class))
                    .collect(Collectors.toList());
    }

    @Transactional
    public UserDTO getUserByID(Long user_ID) {
        UserEntity userEntity = userRepository.findById(user_ID).orElseThrow(() -> new RuntimeException("등록된 사용자가 없습니다."));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Transactional
    public UserDTO createdUser (UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        UserEntity saveUser = userRepository.save(userEntity);
        return modelMapper.map(saveUser, UserDTO.class);
    }

    @Transactional
    public UserDTO updatedUser (Long userID, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(userID)
                                    .orElseThrow(() -> new RuntimeException("등록된 사용자가 없습니다."));
        userEntity.update(userDTO.getId(), userDTO.getName());
        UserEntity updatedUser = userRepository.save(userEntity);
        return modelMapper.map(updatedUser, UserDTO.class);
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
