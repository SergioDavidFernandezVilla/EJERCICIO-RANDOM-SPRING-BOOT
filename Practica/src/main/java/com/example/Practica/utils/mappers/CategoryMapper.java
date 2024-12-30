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
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoryDTO fromEntity(CategoryEntity categoria);

    // Mapeo de CategoryDTO a CategoryEntity
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoryEntity fromDTO(CategoryDTO categoria);
}
