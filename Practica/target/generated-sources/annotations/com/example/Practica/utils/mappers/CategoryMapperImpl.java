package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-04T04:03:05+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO fromEntity(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Long id = null;
        String categoria = null;
        String descripcion = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        id = categoryEntity.getId();
        categoria = categoryEntity.getCategoria();
        descripcion = categoryEntity.getDescripcion();
        created_at = categoryEntity.getCreated_at();
        updated_at = categoryEntity.getUpdated_at();

        CategoryDTO categoryDTO = new CategoryDTO( id, categoria, descripcion, created_at, updated_at );

        return categoryDTO;
    }

    @Override
    public CategoryEntity fromDTO(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.categoria( categoryDTO.categoria() );
        categoryEntity.created_at( categoryDTO.created_at() );
        categoryEntity.descripcion( categoryDTO.descripcion() );
        categoryEntity.id( categoryDTO.id() );
        categoryEntity.updated_at( categoryDTO.updated_at() );

        return categoryEntity.build();
    }
}
