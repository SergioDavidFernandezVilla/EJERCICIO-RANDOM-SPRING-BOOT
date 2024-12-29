package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;


public class CategoryMapper {

     // Mapeo de CategoryEntity a CategoryDTO
     public static CategoryEntity fromDTO(CategoryDTO categoria) {
       return CategoryEntity.builder()
            .nombre(categoria.nombre())
            .descripcion(categoria.descripcion())
            .build();
    }


    // Mapeo de CategoryDTO a CategoryEntity
    public static CategoryDTO fromEntity(CategoryEntity categoria) {
        return new CategoryDTO(
            categoria.getId(),
            categoria.getNombre(),
            categoria.getDescripcion()
        );
    }

}
