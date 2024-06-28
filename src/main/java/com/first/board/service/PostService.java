package com.first.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.board.dto.PostDTO;
import com.first.board.entity.PostEntity;
import com.first.board.repository.PostRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostService (PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<PostDTO> getAllPost(){
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream()
                    .map(PostEntity -> modelMapper.map(PostEntity, PostDTO.class))
                    .collect(Collectors.toList());
    }

    @Transactional
    public PostDTO getPostById (Long post_ID) {
        PostEntity postEntity = postRepository.findById(post_ID).orElseThrow(() -> new RuntimeException("글을 찾을 수 없습니다."));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Transactional
    public PostDTO createdPost (PostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        PostEntity savePost = postRepository.save(postEntity);
        return modelMapper.map(savePost, PostDTO.class);
    }

    @Transactional
    public PostDTO updatedpost(Long postId, PostDTO postDTO) {
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("글을 찾을 수 없습니다."));
        postEntity.update(postDTO.getTitle(), postDTO.getP_Content());
        PostEntity updatedPost = postRepository.save(postEntity);
        return modelMapper.map(updatedPost, PostDTO.class);
    }

    @Transactional
    public void deleteByPostID (Long post_ID) {
        postRepository.deleteById(post_ID);
    }


    public void insertpost() {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("제목");
        postDTO.setPost_PW("글 비밀번호");
        postDTO.setP_Content("냥");

        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        PostEntity savePost = postRepository.save(postEntity);
        modelMapper.map(savePost, PostDTO.class);
        postRepository.save(postEntity);
    }

}
