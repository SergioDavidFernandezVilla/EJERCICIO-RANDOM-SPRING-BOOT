package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-01T05:27:32+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO fromEntity(ProductEntity producto) {
        if ( producto == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String descripcion = null;
        double precio = 0.0d;
        LocalDateTime created_at = null;
        MarcaDTO marca = null;
        CategoryDTO categoria = null;

        id = producto.getId();
        nombre = producto.getNombre();
        descripcion = producto.getDescripcion();
        precio = producto.getPrecio();
        created_at = producto.getCreated_at();
        marca = marcaEntityToMarcaDTO( producto.getMarca() );
        categoria = categoryEntityToCategoryDTO( producto.getCategoria() );

        ProductDTO productDTO = new ProductDTO( id, nombre, descripcion, precio, created_at, marca, categoria );

        return productDTO;
    }

    @Override
    public ProductEntity fromDTO(ProductDTO producto) {
        if ( producto == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.categoria( categoryDTOToCategoryEntity( producto.categoria() ) );
        productEntity.created_at( producto.created_at() );
        productEntity.descripcion( producto.descripcion() );
        productEntity.id( producto.id() );
        productEntity.marca( marcaDTOToMarcaEntity( producto.marca() ) );
        productEntity.nombre( producto.nombre() );
        productEntity.precio( producto.precio() );

        return productEntity.build();
    }

    protected MarcaDTO marcaEntityToMarcaDTO(MarcaEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        Long id = null;
        String marca = null;
        String descripcion = null;
        String created_at = null;
        String updated_at = null;

        id = marcaEntity.getId();
        marca = marcaEntity.getMarca();
        descripcion = marcaEntity.getDescripcion();
        if ( marcaEntity.getCreated_at() != null ) {
            created_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( marcaEntity.getCreated_at() );
        }
        if ( marcaEntity.getUpdated_at() != null ) {
            updated_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( marcaEntity.getUpdated_at() );
        }

        MarcaDTO marcaDTO = new MarcaDTO( id, marca, descripcion, created_at, updated_at );

        return marcaDTO;
    }

    protected CategoryDTO categoryEntityToCategoryDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Long id = null;
        String descripcion = null;
        String created_at = null;
        String updated_at = null;

        id = categoryEntity.getId();
        descripcion = categoryEntity.getDescripcion();
        if ( categoryEntity.getCreated_at() != null ) {
            created_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( categoryEntity.getCreated_at() );
        }
        if ( categoryEntity.getUpdated_at() != null ) {
            updated_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( categoryEntity.getUpdated_at() );
        }

        Set<String> nombre = null;

        CategoryDTO categoryDTO = new CategoryDTO( id, categoria, descripcion, created_at, updated_at );

        return categoryDTO;
    }

    protected CategoryEntity categoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

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

    protected MarcaEntity marcaDTOToMarcaEntity(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        if ( marcaDTO.created_at() != null ) {
            marcaEntity.created_at( LocalDateTime.parse( marcaDTO.created_at() ) );
        }
        marcaEntity.descripcion( marcaDTO.descripcion() );
        marcaEntity.id( marcaDTO.id() );
        marcaEntity.marca( marcaDTO.marca() );
        if ( marcaDTO.updated_at() != null ) {
            marcaEntity.updated_at( LocalDateTime.parse( marcaDTO.updated_at() ) );
        }

        return marcaEntity.build();
    }
}
