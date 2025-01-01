package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-31T23:50:16+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO fromEntity(CategoryEntity categoria) {
        if ( categoria == null ) {
            return null;
        }

        Long id = null;
        Set<String> nombre = null;
        String descripcion = null;

        id = categoria.getId();
        Set<String> set = categoria.getNombre();
        if ( set != null ) {
            nombre = new LinkedHashSet<String>( set );
        }
        descripcion = categoria.getDescripcion();

        CategoryDTO categoryDTO = new CategoryDTO( id, nombre, descripcion );

        return categoryDTO;
    }

    @Override
    public CategoryEntity fromDTO(CategoryDTO categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.id( categoria.id() );
        Set<String> set = categoria.nombre();
        if ( set != null ) {
            categoryEntity.nombre( new LinkedHashSet<String>( set ) );
        }
        categoryEntity.descripcion( categoria.descripcion() );

        return categoryEntity.build();
    }
}
