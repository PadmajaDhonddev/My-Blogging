package com.javabackend.blog.services;

import com.javabackend.blog.entities.Post;
import com.javabackend.blog.payloads.PostDto;

import java.util.List;

public interface PostService {
    //create
    Post createPost(PostDto postDto, Integer userId, Integer categoryId);
    //update
    Post updatePost(PostDto postDto, Integer postId);
    //delete
    void deletePost(Integer postId);

    //get single post by id
    Post getPostById(Integer postId);
    //get all posts by category
    List<Post> getPostsByCategory();

    //get all posts by user
    List<Post> getPostsByUser();

    //get search post by keyword
    List<Post> searchPosts(String keyword);
}
