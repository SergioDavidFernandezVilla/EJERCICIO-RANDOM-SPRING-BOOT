package com.example.Practica.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // Mapeo de ProductEntity a ProductDTO
    ProductDTO fromEntity(ProductEntity product);

    
    ProductEntity fromDTO(ProductDTO product);

}
