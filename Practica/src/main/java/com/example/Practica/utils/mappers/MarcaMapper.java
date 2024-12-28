package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.presentation.controller.dto.MarcaDTO;

public class MarcaMapper {

     // Mapeo de MarcaDTO a MarcaEntity
     public static MarcaEntity fromDTO(MarcaDTO marcaDTO) {
        return MarcaEntity.builder()
        .id(marcaDTO.id())
        .marca(marcaDTO.marca())
        .descripcion(marcaDTO.descripcion())
        .build();
    }

    // Mapeo de MarcaEntity a MarcaDTO
    public static MarcaDTO fromEntity(MarcaEntity marcaDTO) {
        return new MarcaDTO(
            marcaDTO.getId(),
            marcaDTO.getMarca(),
            marcaDTO.getDescripcion()
        );
    }

}
