package com.example.Practica.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.repository.CategoryRepository;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.utils.mappers.CategoryMapper;

@Service
public class CategoryService {
    
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // METODO ALL
    public List<CategoryDTO> findAllCategories(){
        List<CategoryEntity> categories = categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<CategoryDTO> response = categories.stream().map(CategoryMapper.INSTANCE::fromEntity).toList();
        return response;
    }

    // METODO BY ID
    public CategoryDTO findCategoryById(Long id){
        return categoryRepository.findById(id)
            .map(CategoryMapper.INSTANCE::fromEntity)
            .orElseThrow();
    }

    // METODO CREATE
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        CategoryEntity category = CategoryMapper.INSTANCE.fromDTO(categoryDTO);
        CategoryEntity categorySaved = categoryRepository.save(category);
        CategoryDTO responseDTO = CategoryMapper.INSTANCE.fromEntity(categorySaved);
        return responseDTO;
    }
    
    // METODO PUT
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO){
        return categoryRepository.findById(id)
            .map(category -> {
                category.setCategoria(categoryDTO.nombre());
                category.setDescripcion(categoryDTO.descripcion());
                CategoryEntity categoryUpdated = categoryRepository.save(category);
                CategoryDTO responseDTO = CategoryMapper.INSTANCE.fromEntity(categoryUpdated);
                return responseDTO;
            })
            .orElseThrow();
    }

    // METODO DELETE
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
