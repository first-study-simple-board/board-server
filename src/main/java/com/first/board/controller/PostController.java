package com.first.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.board.dto.PostDTO;
import com.first.board.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins="*", allowedHeaders = "*")
@Tag(name = "posts", description = "게시물 API")
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    // @ApiResponses(
    //   value = {
    //        @ApiResponse(
    //            responseCode = "201",
    //            description = "이전까지 회원가입을 하지 않았던 경우",
    //            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
                     
    //        @ApiResponse(
    //            responseCode = "200",
    //            description = "이미 회원가입을 했던 유저인 경우",
    //            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    // })

    @ApiResponses(value = {@ApiResponse(
                                responseCode = "200", description = "OK")})
    @Operation(summary = "posts", description = "게시물을 반환하는 메소드")
    @GetMapping()
    public List<PostDTO> getTruePost() {
        return postService.getAllPost();
    }

    @Operation(summary = "find post", description = "게시물 ID로 찾는 메소드")
    @GetMapping("/{id}")
    public PostDTO findPost(@Parameter(description= "회원 ID", required = true, example= "1") @PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @Operation(summary = "update post", description = "게시물 정보를 변경하는 메소드")
    @PutMapping("/{id}")
    public PostDTO updatePost(@Parameter(description= "회원 ID", required = true, example= "1") @PathVariable("id") Long id, @RequestBody PostDTO postDTO) {
        return postService.updatedpost(id, postDTO);
    }

    @Operation(summary = "create post", description = "새로운 게시물을 저장하는 메소드")
    @PostMapping()
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return postService.createdPost(postDTO);
    }
    
    @Operation(summary = "delete post", description = "게시물을 삭제, 즉 useFlag를 false로 변환하는 메소드")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id")Long id, @RequestBody PostDTO postDTO) {
        postService.deleteByPostID(id, postDTO);
    }
}


    // @ApiResponses({
    //         @ApiResponse(responseCode = "200", description = "OK",
    //                         content = @Content(schema = @Schema(implementation = PostDTO.class))),
    //         @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
    //         @ApiResponse(responseCode = "404", description = "NOT FOUND",
    //                         content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    //         @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR",
    //                         content = @Content(mediaType = "text/plain", examples = @ExampleObject(value = "INTERNAL SERVER ERROR"))),
    // })