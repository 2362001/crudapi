package com.example.crudapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crudapi.dtos.CategoryDTO;
import com.example.crudapi.model.CategoryModel;
import com.example.crudapi.reponses.ResponseObject;
import com.example.crudapi.services.category.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
        private final CategoryService categoryService;

        @PostMapping("/addCategory")
        public ResponseEntity<ResponseObject> createCategory(
                        @Valid @RequestBody CategoryDTO categoryDTO,
                        BindingResult result) {
                if (result.hasErrors()) {
                        List<String> errorMessages = result.getFieldErrors()
                                        .stream()
                                        .map(FieldError::getDefaultMessage)
                                        .toList();
                        return ResponseEntity.ok().body(ResponseObject.builder()
                                        .message(errorMessages.toString())
                                        .status(HttpStatus.BAD_REQUEST)
                                        .data(null)
                                        .build());

                }
                CategoryModel category = categoryService.createCategory(categoryDTO);
                return ResponseEntity.ok().body(ResponseObject.builder()
                                .message("Create category successfully")
                                .status(HttpStatus.OK)
                                .data(category)
                                .build());
        }

        @GetMapping("path")
        public String getMethodName() {
                return "hello wworld";
        }

}
