package com.test.pictora.services;

import com.test.pictora.entities.Category;
import com.test.pictora.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory (CategoryDto categoryDto);
    CategoryDto updateCategory (CategoryDto categoryDto , Integer categoryId);
    public void deleteCategory (Integer categoryId);

    //get single category
    public CategoryDto getCategory (Integer categoryId);
    //get all
    public List<CategoryDto> getAllCategories();


}
