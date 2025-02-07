package com.example.Practica.utils.products.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.products.CategoryEntity;
import com.example.Practica.presentation.products.dto.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Instancia del mapper generada por MapStruct
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "updated_at", source = "updatedAt")
    CategoryDTO fromEntity(CategoryEntity categoryEntity);
    
    @Mapping(target = "productos", ignore = true)
    CategoryEntity fromDTO(CategoryDTO categoryDTO);
}
