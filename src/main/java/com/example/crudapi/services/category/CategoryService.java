package com.example.crudapi.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudapi.dtos.CategoryDTO;
import com.example.crudapi.model.CategoryModel;
import com.example.crudapi.repositories.CategoryRepositories;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepositories categoryRepository;

    @Override
    @Transactional
    public CategoryModel createCategory(CategoryDTO categoryDTO) {
        CategoryModel newCategory = CategoryModel
                .builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(newCategory);
    }


    // @Override
    // public Category getCategoryById(long id) {
    //     throw new UnsupportedOperationException("Unimplemented method 'getCategoryById'");
    // }

    // @Override
    // public List<Category> getAllCategories() {
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    // }

    // @Override
    // public Category updateCategory(long categoryId, CategoryDTO category) {
    //     throw new UnsupportedOperationException("Unimplemented method 'updateCategory'");
    // }

    // @Override
    // public Category deleteCategory(long id) throws Exception {
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteCategory'");
    // }

}
