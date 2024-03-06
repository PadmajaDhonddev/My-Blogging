package com.javabackend.blog.controllers;

import com.javabackend.blog.entities.Post;
import com.javabackend.blog.payloads.ApiResponse;
import com.javabackend.blog.payloads.PostDto;
import com.javabackend.blog.payloads.PostResponse;
import com.javabackend.blog.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;
    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId) {

        PostDto createdPostDto = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);

    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getPostsByUser(@PathVariable Integer userId,
            @RequestParam(value="pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value="pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value="sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value="sortDir", defaultValue = "asc", required = false) String sortDir){
        PostResponse postResponse  = this.postService.getPostsByUser(userId, pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostsByCategory(@PathVariable Integer categoryId,
                                                           @RequestParam(value="pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                           @RequestParam(value="pageSize", defaultValue = "5", required = false) Integer pageSize,
                                                           @RequestParam(value="sortBy", defaultValue = "postId", required = false) String sortBy,
                                                           @RequestParam(value="sortDir", defaultValue = "asc", required = false) String sortDir){
        PostResponse postResponse  = this.postService.getPostsByCategory(categoryId, pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value="pageNumber", defaultValue = "0", required = false) Integer pageNumber
            ,@RequestParam(value="pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value="sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value="sortDir", defaultValue = "asc", required = false) String sortDir){
        PostResponse postResponse = this.postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }

    //get post by id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    //delete post by id

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted successfully.", true), HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
        PostDto updatedPostDto = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPostDto, HttpStatus.OK);
    }
}
