package com.example.Practica.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.presentation.controller.dto.ImageDTO;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "updated_at", source = "updatedAt")
    ImageDTO fromEntity(ImageEntity image);
    ImageEntity fromDTO(ImageDTO image);

    List<ImageDTO> toImageDTOList(List<ImageEntity> images);
}
