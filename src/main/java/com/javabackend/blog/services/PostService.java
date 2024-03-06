package com.javabackend.blog.services;

import com.javabackend.blog.entities.Post;
import com.javabackend.blog.payloads.PostDto;
import com.javabackend.blog.payloads.PostResponse;
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
    PostResponse getPostsByCategory(Integer categoryId,Integer pageNumber, Integer paseSize, String sortBy, String sortDir);

    //get all posts by user
    PostResponse getPostsByUser(Integer userId,Integer pageNumber, Integer paseSize, String sortBy, String sortDir);

    PostResponse getAllPosts(Integer pageNumber, Integer paseSize, String sortBy, String sortDir);

    //get search post by keyword
    List<Post> searchPosts(String keyword);
}
