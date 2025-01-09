package com.example.Practica.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.repository.CategoryRepository;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.utils.mappers.CategoryMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    // METODO ALL
    public List<CategoryDTO> findAllCategories(){
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
        .stream()
        .map(CategoryMapper.INSTANCE::fromEntity)
        .toList();
    }

    // METODO BY ID
    public CategoryDTO findCategoryById(Long id){
        return categoryRepository.findById(id)
            .map(CategoryMapper.INSTANCE::fromEntity)
            .orElseThrow(
                () -> new RuntimeException("La categoria no existe")
            );
    }

    // METODO CREATE
    @Transactional
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        CategoryEntity category = CategoryMapper.INSTANCE.fromDTO(categoryDTO);

       // NOMBRES VALIDOS CON REGEX
        if(categoryDTO.nombre() == null || !categoryDTO.nombre().matches("[a-zA-Z ]+")){
            throw new RuntimeException("El nombre de la categoria no es valido");
        }

        if(categoryRepository.existsByNombre(categoryDTO.nombre())){
            throw new RuntimeException("La categoria ya existe");
        }

        if (categoryDTO.descripcion() == null || !categoryDTO.descripcion().matches("[a-zA-Z0-9 ]+")) {
            throw new RuntimeException("La descripcion de la categoria no es valida");
        }

        CategoryEntity categorySaved = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.fromEntity(categorySaved);
    }
    
    // METODO PUT
    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setNombre(categoryDTO.nombre());
                    category.setDescripcion(categoryDTO.descripcion());
                    return categoryRepository.save(category);
                })
                .map(CategoryMapper.INSTANCE::fromEntity)
                .orElseThrow(() -> new RuntimeException("La categoria con id " + id + " no existe"));
    }


    // METODO DELETE
    @Transactional
    public void deleteCategory(Long id){
        if(!categoryRepository.existsById(id)){
            throw new RuntimeException("La categoria con id " + id + " no existe");
        }
        categoryRepository.deleteById(id);
    }
}
