package com.example.Practica.utils.products.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.products.MarcaEntity;
import com.example.Practica.presentation.controller.dto.MarcaDTO;


@Mapper(componentModel = "spring")
public interface MarcaMapper {

    MarcaMapper INSTANCE = Mappers.getMapper(MarcaMapper.class);

    // DTO <-> Entity
    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "updated_at", source = "updatedAt")
    MarcaDTO fromEntity(MarcaEntity marca);

    // Entity <-> DTO
    @Mapping(target = "productos", ignore = true)
    MarcaEntity fromDTO(MarcaDTO marca);

}
