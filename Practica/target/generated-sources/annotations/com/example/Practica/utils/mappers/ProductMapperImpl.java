package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.presentation.controller.dto.ImageDTO;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-10T05:08:36+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO fromEntity(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        Double precio = null;
        CategoryDTO categoria = null;
        MarcaDTO marca = null;
        ImageDTO image = null;

        created_at = product.getCreatedAt();
        updated_at = product.getUpdatedAt();
        id = product.getId();
        nombre = product.getNombre();
        descripcion = product.getDescripcion();
        precio = product.getPrecio();
        categoria = categoryEntityToCategoryDTO( product.getCategoria() );
        marca = marcaEntityToMarcaDTO( product.getMarca() );
        image = imageEntityToImageDTO( product.getImage() );

        ProductDTO productDTO = new ProductDTO( id, nombre, descripcion, precio, created_at, updated_at, categoria, marca, image );

        return productDTO;
    }

    @Override
    public ProductEntity fromDTO(ProductDTO product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.categoria( categoryDTOToCategoryEntity( product.categoria() ) );
        productEntity.descripcion( product.descripcion() );
        productEntity.id( product.id() );
        productEntity.image( imageDTOToImageEntity( product.image() ) );
        productEntity.marca( marcaDTOToMarcaEntity( product.marca() ) );
        productEntity.nombre( product.nombre() );
        if ( product.precio() != null ) {
            productEntity.precio( product.precio() );
        }

        return productEntity.build();
    }

    protected CategoryDTO categoryEntityToCategoryDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String descripcion = null;

        id = categoryEntity.getId();
        nombre = categoryEntity.getNombre();
        descripcion = categoryEntity.getDescripcion();

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        CategoryDTO categoryDTO = new CategoryDTO( id, nombre, descripcion, created_at, updated_at );

        return categoryDTO;
    }

    protected MarcaDTO marcaEntityToMarcaDTO(MarcaEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String descripcion = null;

        id = marcaEntity.getId();
        nombre = marcaEntity.getNombre();
        descripcion = marcaEntity.getDescripcion();

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        MarcaDTO marcaDTO = new MarcaDTO( id, nombre, descripcion, created_at, updated_at );

        return marcaDTO;
    }

    protected ImageDTO imageEntityToImageDTO(ImageEntity imageEntity) {
        if ( imageEntity == null ) {
            return null;
        }

        Long id = null;
        String type = null;
        String fileName = null;

        id = imageEntity.getId();
        type = imageEntity.getType();
        fileName = imageEntity.getFileName();

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        ImageDTO imageDTO = new ImageDTO( id, type, fileName, created_at, updated_at );

        return imageDTO;
    }

    protected CategoryEntity categoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.descripcion( categoryDTO.descripcion() );
        categoryEntity.id( categoryDTO.id() );
        categoryEntity.nombre( categoryDTO.nombre() );

        return categoryEntity.build();
    }

    protected ImageEntity imageDTOToImageEntity(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        ImageEntity.ImageEntityBuilder imageEntity = ImageEntity.builder();

        imageEntity.fileName( imageDTO.fileName() );
        imageEntity.id( imageDTO.id() );
        imageEntity.type( imageDTO.type() );

        return imageEntity.build();
    }

    protected MarcaEntity marcaDTOToMarcaEntity(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        marcaEntity.descripcion( marcaDTO.descripcion() );
        marcaEntity.id( marcaDTO.id() );
        marcaEntity.nombre( marcaDTO.nombre() );

        return marcaEntity.build();
    }
}
