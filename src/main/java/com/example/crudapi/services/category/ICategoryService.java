package com.example.crudapi.services.category;

import java.util.List;
import java.util.Locale.Category;

import com.example.crudapi.dtos.CategoryDTO;
import com.example.crudapi.model.CategoryModel;

public interface ICategoryService {
    CategoryModel createCategory(CategoryDTO category);

    // Category getCategoryById(long id);

    // List<Category> getAllCategories();

    // Category updateCategory(long categoryId, CategoryDTO category);

    // Category deleteCategory(long id) throws Exception;
}
