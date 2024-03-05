package com.javabackend.blog.services;

import com.javabackend.blog.entities.Post;
import com.javabackend.blog.payloads.PostDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    //update
    PostDto updatePost(PostDto postDto, Integer postId);
    //delete
    void deletePost(Integer postId);

    //get single post by id
    PostDto getPostById(Integer postId);
    //get all posts by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    List<PostDto> getAllPosts(Integer pageNumber, Integer paseSize);

    //get search post by keyword
    List<Post> searchPosts(String keyword);
}
