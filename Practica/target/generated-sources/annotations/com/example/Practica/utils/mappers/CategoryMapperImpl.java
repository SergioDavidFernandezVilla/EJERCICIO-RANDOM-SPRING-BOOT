package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-01T20:10:40+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO fromEntity(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        String categoria = null;
        String descripcion = null;

        categoria = categoryEntity.getCategoria();
        descripcion = categoryEntity.getDescripcion();

        Long id = null;

        CategoryDTO categoryDTO = new CategoryDTO( id, categoria, descripcion );

        return categoryDTO;
    }

    @Override
    public CategoryEntity fromDTO(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.categoria( categoryDTO.categoria() );
        categoryEntity.descripcion( categoryDTO.descripcion() );
        categoryEntity.id( categoryDTO.id() );

        return categoryEntity.build();
    }
}
