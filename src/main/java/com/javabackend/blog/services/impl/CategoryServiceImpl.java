package com.javabackend.blog.services.impl;

import com.javabackend.blog.entities.Category;
import com.javabackend.blog.exceptions.ResourceNotFoundException;
import com.javabackend.blog.payloads.CategoryDto;
import com.javabackend.blog.repositories.CategoryRepository;
import com.javabackend.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        this.categoryRepository.save(category);
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category originalCategory = this.categoryRepository.findById(categoryId)
               .orElseThrow(() -> new ResourceNotFoundException("Category ","Category id ", categoryId));
       originalCategory.setCategoryTitle(categoryDto.getCategoryTitle());
       originalCategory.setCategoryDescription(categoryDto.getCategoryDescription());
       this.categoryRepository.save(originalCategory);
       return this.modelMapper.map(originalCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ","Category id ", categoryId));
        this.categoryRepository.delete(category);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ","Category id ", categoryId));
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).toList();
        return categoryDtos;
    }
}
