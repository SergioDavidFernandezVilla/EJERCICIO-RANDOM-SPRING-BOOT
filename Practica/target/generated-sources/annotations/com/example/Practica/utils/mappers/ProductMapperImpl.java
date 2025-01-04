package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-04T01:11:00+0000",
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
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        id = category.getId();
        categoria = category.getCategoria();
        descripcion = category.getDescripcion();
        created_at = category.getCreated_at();
        updated_at = category.getUpdated_at();

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
        categoryEntity.created_at( category.created_at() );
        categoryEntity.descripcion( category.descripcion() );
        categoryEntity.id( category.id() );
        categoryEntity.updated_at( category.updated_at() );

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
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        id = marca.getId();
        marca1 = marca.getMarca();
        descripcion = marca.getDescripcion();
        created_at = marca.getCreated_at();
        updated_at = marca.getUpdated_at();

        MarcaDTO marcaDTO = new MarcaDTO( id, marca1, descripcion, created_at, updated_at );

        return marcaDTO;
    }

    @Override
    public MarcaEntity fromDTO(MarcaDTO marca) {
        if ( marca == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        marcaEntity.created_at( marca.created_at() );
        marcaEntity.descripcion( marca.descripcion() );
        marcaEntity.id( marca.id() );
        marcaEntity.marca( marca.marca() );
        marcaEntity.updated_at( marca.updated_at() );

        return marcaEntity.build();
    }
}
