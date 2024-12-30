package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T19:53:02+0000",
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

        id = marca.getId();
        marca1 = marca.getMarca();
        descripcion = marca.getDescripcion();

        MarcaDTO marcaDTO = new MarcaDTO( id, marca1, descripcion );

        return marcaDTO;
    }

    @Override
    public MarcaEntity fromDTO(MarcaDTO marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        marcaEntity.descripcion( marca.descripcion() );
        marcaEntity.id( marca.id() );
        marcaEntity.marca( marca.marca() );

        return marcaEntity.build();
    }
}
