package com.javabackend.blog.payloads;

import com.javabackend.blog.entities.Category;
import com.javabackend.blog.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private Integer postId;
    @NotEmpty(message = "Post title is required")
    @Size(min = 4, message = "Post title must be min 4 characters")
    private String title;

    @NotEmpty(message = "Post content is required")
    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

}
