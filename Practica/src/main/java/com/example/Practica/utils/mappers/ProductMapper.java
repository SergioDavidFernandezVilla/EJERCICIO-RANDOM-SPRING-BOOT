package com.example.Practica.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;

import com.example.Practica.presentation.controller.dto.*;
import com.example.Practica.presentation.controller.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // Mapeo de ProductEntity a ProductDTO
    ProductDTO fromEntity(ProductEntity product);
    ProductEntity fromDTO(ProductDTO product);

    // Mapeo de CategoryEntity a CategoryDTO
    CategoryDTO fromEntity(CategoryEntity category);
    CategoryEntity fromDTO(CategoryDTO category);

    // Mapeo de MarcaEntity a MarcaDTO
    MarcaDTO fromEntity(MarcaEntity marca);
    MarcaEntity fromDTO(MarcaDTO marca);

}
