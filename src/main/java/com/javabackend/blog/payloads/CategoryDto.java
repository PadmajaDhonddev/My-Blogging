package com.javabackend.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotEmpty
    @Size(min = 4, max = 30, message = "Title must be min 4 characters and max 20 characters")
    private String categoryTitle;

    @Size(min = 10, message = "Category Description must be min 10 characters.")
    private String categoryDescription;

}
