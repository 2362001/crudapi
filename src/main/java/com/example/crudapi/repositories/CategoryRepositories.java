package com.example.crudapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudapi.model.CategoryModel;

@Repository
public interface CategoryRepositories extends JpaRepository<CategoryModel, Long> {

}
