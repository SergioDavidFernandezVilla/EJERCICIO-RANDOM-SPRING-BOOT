package com.example.Practica.services;

import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.persistence.repository.CategoryRepository;
import com.example.Practica.persistence.repository.MarcaRepository;
import com.example.Practica.persistence.repository.ProductRepository;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import com.example.Practica.utils.mappers.ProductMapper;

import jakarta.transaction.Transactional;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MarcaRepository marcaRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, MarcaRepository marcaRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.marcaRepository = marcaRepository;
        this.categoryRepository = categoryRepository;
    }

    // METODO CREATE
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {

        // Crear una instancia de ProductEntity a partir del DTO
        ProductEntity product = ProductMapper.INSTANCE.fromDTO(productDTO);

        // Obtener las entidades MarcaEntity y CategoryEntity correspondientes
        MarcaEntity marca = marcaRepository.findById(productDTO.marca().id())
            .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
        CategoryEntity category = categoryRepository.findById(productDTO.categoria().id())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // Asignar las entidades MarcaEntity y CategoryEntity a la entidad ProductEntity
        product.setMarca(marca);
        product.setCategoria(category);

        // Guardar la entidad ProductEntity en la base de datos
        ProductEntity productSaved = productRepository.save(product);
        return ProductMapper.INSTANCE.fromEntity(productSaved);
    }


}   