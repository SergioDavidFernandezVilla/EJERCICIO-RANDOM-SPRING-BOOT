package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-01T05:41:26+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO fromEntity(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        List<String> categoria = null;
        String descripcion = null;
        String created_at = null;
        String updated_at = null;

        List<String> list = categoryEntity.getCategoria();
        if ( list != null ) {
            categoria = new ArrayList<String>( list );
        }
        descripcion = categoryEntity.getDescripcion();
        if ( categoryEntity.getCreated_at() != null ) {
            created_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( categoryEntity.getCreated_at() );
        }
        if ( categoryEntity.getUpdated_at() != null ) {
            updated_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( categoryEntity.getUpdated_at() );
        }

        Long id = null;

        CategoryDTO categoryDTO = new CategoryDTO( id, categoria, descripcion, created_at, updated_at );

        return categoryDTO;
    }

    @Override
    public CategoryEntity fromDTO(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        List<String> list = categoryDTO.categoria();
        if ( list != null ) {
            categoryEntity.categoria( new ArrayList<String>( list ) );
        }
        if ( categoryDTO.created_at() != null ) {
            categoryEntity.created_at( LocalDateTime.parse( categoryDTO.created_at() ) );
        }
        categoryEntity.descripcion( categoryDTO.descripcion() );
        categoryEntity.id( categoryDTO.id() );
        if ( categoryDTO.updated_at() != null ) {
            categoryEntity.updated_at( LocalDateTime.parse( categoryDTO.updated_at() ) );
        }

        return categoryEntity.build();
    }
}
