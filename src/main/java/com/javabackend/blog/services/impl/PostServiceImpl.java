package com.javabackend.blog.services.impl;

import com.javabackend.blog.entities.Post;
import com.javabackend.blog.payloads.PostDto;
import com.javabackend.blog.repositories.CategoryRepository;
import com.javabackend.blog.repositories.PostRepository;
import com.javabackend.blog.repositories.UserRepository;
import com.javabackend.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Post createPost(PostDto postDto, Integer userId, Integer categoryId) {
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        return null;
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory() {
        return null;
    }

    @Override
    public List<Post> getPostsByUser() {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
