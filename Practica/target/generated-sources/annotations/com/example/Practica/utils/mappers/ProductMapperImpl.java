package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-01T04:08:01+0000",
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

        id = marcaEntity.getId();
        marca = marcaEntity.getMarca();
        descripcion = marcaEntity.getDescripcion();

        MarcaDTO marcaDTO = new MarcaDTO( id, marca, descripcion );

        return marcaDTO;
    }

    protected CategoryDTO categoryEntityToCategoryDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Long id = null;
        Set<String> nombre = null;
        String descripcion = null;

        id = categoryEntity.getId();
        Set<String> set = categoryEntity.getNombre();
        if ( set != null ) {
            nombre = new LinkedHashSet<String>( set );
        }
        descripcion = categoryEntity.getDescripcion();

        CategoryDTO categoryDTO = new CategoryDTO( id, nombre, descripcion );

        return categoryDTO;
    }

    protected CategoryEntity categoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.descripcion( categoryDTO.descripcion() );
        categoryEntity.id( categoryDTO.id() );
        Set<String> set = categoryDTO.nombre();
        if ( set != null ) {
            categoryEntity.nombre( new LinkedHashSet<String>( set ) );
        }

        return categoryEntity.build();
    }

    protected MarcaEntity marcaDTOToMarcaEntity(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        marcaEntity.descripcion( marcaDTO.descripcion() );
        marcaEntity.id( marcaDTO.id() );
        marcaEntity.marca( marcaDTO.marca() );

        return marcaEntity.build();
    }
}
