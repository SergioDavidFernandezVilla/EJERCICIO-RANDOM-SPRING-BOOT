package com.example.Practica.utils.products.mappers;

import com.example.Practica.persistence.entity.products.CategoryEntity;
import com.example.Practica.persistence.entity.products.ImageEntity;
import com.example.Practica.persistence.entity.products.MarcaEntity;
import com.example.Practica.persistence.entity.products.ProductEntity;
import com.example.Practica.presentation.products.dto.CategoryDTO;
import com.example.Practica.presentation.products.dto.ImageDTO;
import com.example.Practica.presentation.products.dto.MarcaDTO;
import com.example.Practica.presentation.products.dto.ProductDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T03:54:05+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250107-1446, environment: Java 21.0.3 (N/A)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO fromEntity(ProductEntity product) {
        if ( product == null ) {
            return null;
        }

        CategoryDTO categoria = null;
        ImageDTO image = null;
        MarcaDTO marca = null;
        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        Double precio = null;

        categoria = categoryEntityToCategoryDTO( product.getCategoria() );
        image = imageEntityToImageDTO( product.getImage() );
        marca = marcaEntityToMarcaDTO( product.getMarca() );
        created_at = product.getCreatedAt();
        updated_at = product.getUpdatedAt();
        id = product.getId();
        nombre = product.getNombre();
        descripcion = product.getDescripcion();
        precio = product.getPrecio();

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

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        created_at = categoryEntity.getCreatedAt();
        updated_at = categoryEntity.getUpdatedAt();
        id = categoryEntity.getId();
        nombre = categoryEntity.getNombre();
        descripcion = categoryEntity.getDescripcion();

        CategoryDTO categoryDTO = new CategoryDTO( id, nombre, descripcion, created_at, updated_at );

        return categoryDTO;
    }

    protected ImageDTO imageEntityToImageDTO(ImageEntity imageEntity) {
        if ( imageEntity == null ) {
            return null;
        }

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        Long id = null;
        String type = null;
        String fileName = null;

        created_at = imageEntity.getCreatedAt();
        updated_at = imageEntity.getUpdatedAt();
        id = imageEntity.getId();
        type = imageEntity.getType();
        fileName = imageEntity.getFileName();

        ImageDTO imageDTO = new ImageDTO( id, type, fileName, created_at, updated_at );

        return imageDTO;
    }

    protected MarcaDTO marcaEntityToMarcaDTO(MarcaEntity marcaEntity) {
        if ( marcaEntity == null ) {
            return null;
        }

        LocalDateTime created_at = null;
        LocalDateTime updated_at = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        created_at = marcaEntity.getCreatedAt();
        updated_at = marcaEntity.getUpdatedAt();
        id = marcaEntity.getId();
        nombre = marcaEntity.getNombre();
        descripcion = marcaEntity.getDescripcion();

        MarcaDTO marcaDTO = new MarcaDTO( id, nombre, descripcion, created_at, updated_at );

        return marcaDTO;
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
