package com.example.Practica.utils.products.mappers;

import com.example.Practica.persistence.entity.products.CategoryEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T01:46:19+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO fromEntity(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        created_at = categoryEntity.getCreatedAt();
        updated_at = categoryEntity.getUpdatedAt();
        id = categoryEntity.getId();
        nombre = categoryEntity.getNombre();
        descripcion = categoryEntity.getDescripcion();

        CategoryDTO categoryDTO = new CategoryDTO( id, nombre, descripcion, created_at, updated_at );

        return categoryDTO;
    }

    @Override
    public CategoryEntity fromDTO(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.descripcion( categoryDTO.descripcion() );
        categoryEntity.id( categoryDTO.id() );
        categoryEntity.nombre( categoryDTO.nombre() );

        return categoryEntity.build();
    }
}
