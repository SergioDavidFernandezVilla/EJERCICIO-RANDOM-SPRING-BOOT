package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.ProductDTO;

public class ProductMapper {

    // Mapeo de ProductDTO a ProductEntity
    public static ProductEntity fromDTO(ProductDTO productDTO) {
        return ProductEntity.builder()
            .id(productDTO.id())
            .nombre(productDTO.nombre())
            .precio(productDTO.precio())
            .descripcion(productDTO.descripcion())
            .marca(MarcaMapper.fromDTO(productDTO.marca())) // Mapeo de marca
            .categoria(CategoryMapper.fromDTO(productDTO.categoria())) // Mapeo de categoría
            .build();
    }

    // Mapeo de ProductEntity a ProductDTO
    public static ProductDTO fromEntity(ProductEntity productEntity) {
        return new ProductDTO(
            productEntity.getId(),
            productEntity.getNombre(),
            productEntity.getDescripcion(),
            productEntity.getPrecio(),
            productEntity.getCreated_at(),
            MarcaMapper.fromEntity(productEntity.getMarca()), // Mapeo de marca
            CategoryMapper.fromEntity(productEntity.getCategoria()) // Mapeo de categoría
        );
    }
}