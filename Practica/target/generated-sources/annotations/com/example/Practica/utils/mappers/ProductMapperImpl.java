package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-01T22:02:22+0000",
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
        LocalDateTime updated_at = null;

        id = producto.getId();
        nombre = producto.getNombre();
        descripcion = producto.getDescripcion();
        precio = producto.getPrecio();
        created_at = producto.getCreated_at();
        updated_at = producto.getUpdated_at();

        ProductDTO productDTO = new ProductDTO( id, nombre, descripcion, precio, created_at, updated_at );

        return productDTO;
    }

    @Override
    public ProductEntity fromDTO(ProductDTO producto) {
        if ( producto == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.created_at( producto.created_at() );
        productEntity.descripcion( producto.descripcion() );
        productEntity.id( producto.id() );
        productEntity.nombre( producto.nombre() );
        productEntity.precio( producto.precio() );
        productEntity.updated_at( producto.updated_at() );

        return productEntity.build();
    }
}
