package com.example.Practica.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Instancia del mapper generada por MapStruct
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    // Mapeo de CategoryEntity a CategoryDTO
    @Mapping(target = "id", ignore = true)
    CategoryDTO fromEntity(CategoryEntity categoryEntity);

    // Mapeo de CategoryDTO a CategoryEntity
    CategoryEntity fromDTO(CategoryDTO categoryDTO);
}
