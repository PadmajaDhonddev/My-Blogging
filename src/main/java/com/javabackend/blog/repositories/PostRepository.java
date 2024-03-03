package com.javabackend.blog.repositories;

import com.javabackend.blog.entities.Category;
import com.javabackend.blog.entities.Post;
import com.javabackend.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
