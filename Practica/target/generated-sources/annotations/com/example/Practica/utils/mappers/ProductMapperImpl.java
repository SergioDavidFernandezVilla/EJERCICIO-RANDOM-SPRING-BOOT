package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-02T01:16:04+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO fromEntity(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String descripcion = null;
        Double precio = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        CategoryDTO categoria = null;
        MarcaDTO marca = null;

        id = product.getId();
        nombre = product.getNombre();
        descripcion = product.getDescripcion();
        precio = product.getPrecio();
        created_at = product.getCreated_at();
        updated_at = product.getUpdated_at();
        categoria = fromEntity( product.getCategoria() );
        marca = fromEntity( product.getMarca() );

        ProductDTO productDTO = new ProductDTO( id, nombre, descripcion, precio, created_at, updated_at, categoria, marca );

        return productDTO;
    }

    @Override
    public ProductEntity fromDTO(ProductDTO product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.categoria( fromDTO( product.categoria() ) );
        productEntity.created_at( product.created_at() );
        productEntity.descripcion( product.descripcion() );
        productEntity.id( product.id() );
        productEntity.marca( fromDTO( product.marca() ) );
        productEntity.nombre( product.nombre() );
        if ( product.precio() != null ) {
            productEntity.precio( product.precio() );
        }
        productEntity.updated_at( product.updated_at() );

        return productEntity.build();
    }

    @Override
    public ProductDTO fromEntityWithRelations(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        CategoryDTO categoria = null;
        MarcaDTO marca = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        Double precio = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        categoria = fromEntity( product.getCategoria() );
        marca = fromEntity( product.getMarca() );
        id = product.getId();
        nombre = product.getNombre();
        descripcion = product.getDescripcion();
        precio = product.getPrecio();
        created_at = product.getCreated_at();
        updated_at = product.getUpdated_at();

        ProductDTO productDTO = new ProductDTO( id, nombre, descripcion, precio, created_at, updated_at, categoria, marca );

        return productDTO;
    }

    @Override
    public CategoryDTO fromEntity(CategoryEntity category) {
        if ( category == null ) {
            return null;
        }

        Long id = null;
        String categoria = null;
        String descripcion = null;
        String created_at = null;
        String updated_at = null;

        id = category.getId();
        categoria = category.getCategoria();
        descripcion = category.getDescripcion();
        if ( category.getCreated_at() != null ) {
            created_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( category.getCreated_at() );
        }
        if ( category.getUpdated_at() != null ) {
            updated_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( category.getUpdated_at() );
        }

        CategoryDTO categoryDTO = new CategoryDTO( id, categoria, descripcion, created_at, updated_at );

        return categoryDTO;
    }

    @Override
    public CategoryEntity fromDTO(CategoryDTO category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.categoria( category.categoria() );
        if ( category.created_at() != null ) {
            categoryEntity.created_at( LocalDateTime.parse( category.created_at() ) );
        }
        categoryEntity.descripcion( category.descripcion() );
        categoryEntity.id( category.id() );
        if ( category.updated_at() != null ) {
            categoryEntity.updated_at( LocalDateTime.parse( category.updated_at() ) );
        }

        return categoryEntity.build();
    }

    @Override
    public MarcaDTO fromEntity(MarcaEntity marca) {
        if ( marca == null ) {
            return null;
        }

        Long id = null;
        String marca1 = null;
        String descripcion = null;
        String created_at = null;
        String updated_at = null;

        id = marca.getId();
        marca1 = marca.getMarca();
        descripcion = marca.getDescripcion();
        if ( marca.getCreated_at() != null ) {
            created_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( marca.getCreated_at() );
        }
        if ( marca.getUpdated_at() != null ) {
            updated_at = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( marca.getUpdated_at() );
        }

        MarcaDTO marcaDTO = new MarcaDTO( id, marca1, descripcion, created_at, updated_at );

        return marcaDTO;
    }

    @Override
    public MarcaEntity fromDTO(MarcaDTO marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        if ( marca.created_at() != null ) {
            marcaEntity.created_at( LocalDateTime.parse( marca.created_at() ) );
        }
        marcaEntity.descripcion( marca.descripcion() );
        marcaEntity.id( marca.id() );
        marcaEntity.marca( marca.marca() );
        if ( marca.updated_at() != null ) {
            marcaEntity.updated_at( LocalDateTime.parse( marca.updated_at() ) );
        }

        return marcaEntity.build();
    }
}
