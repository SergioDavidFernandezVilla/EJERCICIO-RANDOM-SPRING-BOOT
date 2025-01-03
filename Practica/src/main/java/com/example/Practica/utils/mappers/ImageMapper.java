package com.example.Practica.utils.mappers;

import org.mapstruct.Mapper;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.presentation.controller.dto.ImageDTO;

@Mapper
public interface ImageMapper {
    
    // Convertir un DTO en una entidad
    ImageEntity toEntity(ImageDTO dto);

    // Convertir una entidad en un DTO
    ImageDTO toDTO(ImageEntity entity);
}
