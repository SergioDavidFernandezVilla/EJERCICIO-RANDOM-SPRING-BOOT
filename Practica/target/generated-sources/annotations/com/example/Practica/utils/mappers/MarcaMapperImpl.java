package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-04T05:43:52+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public MarcaDTO fromEntity(MarcaEntity marca) {
        if ( marca == null ) {
            return null;
        }

        Long id = null;
        String marca1 = null;
        String descripcion = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        id = marca.getId();
        marca1 = marca.getMarca();
        descripcion = marca.getDescripcion();
        created_at = marca.getCreated_at();
        updated_at = marca.getUpdated_at();

        MarcaDTO marcaDTO = new MarcaDTO( id, marca1, descripcion, created_at, updated_at );

        return marcaDTO;
    }

    @Override
    public MarcaEntity fromDTO(MarcaDTO marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        marcaEntity.created_at( marca.created_at() );
        marcaEntity.descripcion( marca.descripcion() );
        marcaEntity.id( marca.id() );
        marcaEntity.marca( marca.marca() );
        marcaEntity.updated_at( marca.updated_at() );

        return marcaEntity.build();
    }
}
