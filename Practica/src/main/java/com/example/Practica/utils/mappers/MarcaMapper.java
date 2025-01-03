package com.example.Practica.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.presentation.controller.dto.MarcaDTO;


@Mapper(componentModel = "spring")
public interface MarcaMapper {

    MarcaMapper INSTANCE = Mappers.getMapper(MarcaMapper.class);

    MarcaDTO fromEntity(MarcaEntity marca);

    MarcaEntity fromDTO(MarcaDTO marca);

}
