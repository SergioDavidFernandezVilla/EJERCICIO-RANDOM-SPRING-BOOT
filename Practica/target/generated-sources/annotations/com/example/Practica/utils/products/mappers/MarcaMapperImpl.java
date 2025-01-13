package com.example.Practica.utils.products.mappers;

import com.example.Practica.persistence.entity.products.MarcaEntity;
import com.example.Practica.presentation.products.dto.MarcaDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-13T01:48:34+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250107-1446, environment: Java 21.0.3 (N/A)"
)
@Component
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public MarcaDTO fromEntity(MarcaEntity marca) {
        if ( marca == null ) {
            return null;
        }

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        created_at = marca.getCreatedAt();
        updated_at = marca.getUpdatedAt();
        id = marca.getId();
        nombre = marca.getNombre();
        descripcion = marca.getDescripcion();

        MarcaDTO marcaDTO = new MarcaDTO( id, nombre, descripcion, created_at, updated_at );

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
        marcaEntity.nombre( marca.nombre() );

        return marcaEntity.build();
    }
}
