package com.javabackend.blog.services;

import com.javabackend.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
     CategoryDto createCategory(CategoryDto categoryDto);
    //update
     CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    //delete
     void deleteCategory(Integer categoryId);
    //get single
     CategoryDto getCategory(Integer categoryId);
    //get all
     List<CategoryDto> getAllCategories();
}
