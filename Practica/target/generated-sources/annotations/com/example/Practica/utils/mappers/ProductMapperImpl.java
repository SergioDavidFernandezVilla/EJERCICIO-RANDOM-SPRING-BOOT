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
    date = "2025-01-05T20:35:51+0000",
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
        ImageDTO image = null;

        id = product.getId();
        nombre = product.getNombre();
        descripcion = product.getDescripcion();
        precio = product.getPrecio();
        created_at = product.getCreated_at();
        updated_at = product.getUpdated_at();
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
        productEntity.created_at( product.created_at() );
        productEntity.descripcion( product.descripcion() );
        productEntity.id( product.id() );
        productEntity.image( imageDTOToImageEntity( product.image() ) );
        productEntity.marca( marcaDTOToMarcaEntity( product.marca() ) );
        productEntity.nombre( product.nombre() );
        if ( product.precio() != null ) {
            productEntity.precio( product.precio() );
        }
        productEntity.updated_at( product.updated_at() );

        return productEntity.build();
    }

    protected CategoryDTO categoryEntityToCategoryDTO(CategoryEntity categoryEntity) {
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

    protected MarcaDTO marcaEntityToMarcaDTO(MarcaEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        Long id = null;
        String marca = null;
        String descripcion = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;

        id = marcaEntity.getId();
        marca = marcaEntity.getMarca();
        descripcion = marcaEntity.getDescripcion();
        created_at = marcaEntity.getCreated_at();
        updated_at = marcaEntity.getUpdated_at();

        MarcaDTO marcaDTO = new MarcaDTO( id, marca, descripcion, created_at, updated_at );

        return marcaDTO;
    }

    protected ImageDTO imageEntityToImageDTO(ImageEntity imageEntity) {
        if ( imageEntity == null ) {
            return null;
        }

        Long id = null;
        String type = null;
        String fileName = null;
        String filePath = null;
        LocalDateTime updated_at = null;

        id = imageEntity.getId();
        type = imageEntity.getType();
        fileName = imageEntity.getFileName();
        filePath = imageEntity.getFilePath();
        updated_at = imageEntity.getUpdated_at();

        ImageDTO imageDTO = new ImageDTO( id, type, fileName, filePath, updated_at );

        return imageDTO;
    }

    protected CategoryEntity categoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
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

    protected ImageEntity imageDTOToImageEntity(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        ImageEntity.ImageEntityBuilder imageEntity = ImageEntity.builder();

        imageEntity.fileName( imageDTO.fileName() );
        imageEntity.filePath( imageDTO.filePath() );
        imageEntity.id( imageDTO.id() );
        imageEntity.type( imageDTO.type() );
        imageEntity.updated_at( imageDTO.updated_at() );

        return imageEntity.build();
    }

    protected MarcaEntity marcaDTOToMarcaEntity(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        MarcaEntity.MarcaEntityBuilder marcaEntity = MarcaEntity.builder();

        marcaEntity.created_at( marcaDTO.created_at() );
        marcaEntity.descripcion( marcaDTO.descripcion() );
        marcaEntity.id( marcaDTO.id() );
        marcaEntity.marca( marcaDTO.marca() );
        marcaEntity.updated_at( marcaDTO.updated_at() );

        return marcaEntity.build();
    }
}
