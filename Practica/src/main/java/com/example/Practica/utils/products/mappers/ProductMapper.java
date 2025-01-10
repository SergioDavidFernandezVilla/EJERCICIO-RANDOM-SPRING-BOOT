package com.example.Practica.utils.products.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.products.ProductEntity;
import com.example.Practica.presentation.controller.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "updated_at", source = "updatedAt")

    // MAPPING CATEGORY IN PRODUCT
    @Mapping(target = "categoria.created_at", source = "categoria.createdAt")
    @Mapping(target = "categoria.updated_at", source = "categoria.updatedAt")

    // MAPPING IMAGE IN PRODUCT
    @Mapping(target = "image.created_at", source = "image.createdAt")
    @Mapping(target = "image.updated_at", source = "image.updatedAt")
     
    // MAPPING MARCA NOT MAPPER
    @Mapping(target = "marca.created_at", source = "marca.createdAt")
    @Mapping(target = "marca.updated_at", source = "marca.updatedAt")
    ProductDTO fromEntity(ProductEntity product);

    // MAPPING CATEGORY NOT MAPPER
    @Mapping(target = "category.filePath", ignore = true)
    @Mapping(target = "categoria.productos", ignore = true)

    // MAPPING IMAGE NOT MAPPER
    @Mapping(target = "image.productos", ignore = true)
    @Mapping(target = "image.filePath", ignore = true)

    // MAPPING MARCA NOT MAPPER
    @Mapping(target = "marca.productos", ignore = true)
    ProductEntity fromDTO(ProductDTO product);

}
