package com.example.Practica.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // METODO ALL
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> findAllCategories(){
        List<CategoryDTO> response = categoryService.findAllCategories();
        return ResponseEntity.ok(response);
    }

    // METODO BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable Long id){
        CategoryDTO responseDTO = categoryService.findCategoryById(id);
        return ResponseEntity.ok(responseDTO);
    }

    // METODO CREATE
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(CategoryDTO categoryDTO){
        CategoryDTO responseDTO = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // METODO PUT
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, CategoryDTO categoryDTO){
        CategoryDTO responseDTO = categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // METODO DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
