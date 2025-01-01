package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-01T21:15:40+0000",
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

        id = producto.getId();
        nombre = producto.getNombre();
        descripcion = producto.getDescripcion();
        precio = producto.getPrecio();

        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        ProductDTO productDTO = new ProductDTO( id, nombre, descripcion, precio, createdAt, updatedAt );

        return productDTO;
    }

    @Override
    public ProductEntity fromDTO(ProductDTO producto) {
        if ( producto == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.descripcion( producto.descripcion() );
        productEntity.id( producto.id() );
        productEntity.nombre( producto.nombre() );
        productEntity.precio( producto.precio() );

        return productEntity.build();
    }
}
