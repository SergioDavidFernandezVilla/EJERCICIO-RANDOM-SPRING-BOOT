package com.example.Practica.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.persistence.repository.CategoryRepository;
import com.example.Practica.persistence.repository.MarcaRepository;
import com.example.Practica.persistence.repository.ProductRepository;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import com.example.Practica.utils.mappers.CategoryMapper;
import com.example.Practica.utils.mappers.MarcaMapper;
import com.example.Practica.utils.mappers.ProductMapper;

import jakarta.transaction.Transactional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public ProductDTO productCreate(ProductDTO productDTO) {
        try {
            // Crear o buscar la marca
            MarcaEntity marcaEntity = marcaRepository.findById(productDTO.marca().id())
                .orElseGet(() -> marcaRepository.save(MarcaMapper.fromDTO(productDTO.marca())));

            // Crear o buscar la categoría
            CategoryEntity categoryEntity = categoryRepository.findById(productDTO.categoria().id())
                .orElseGet(() -> categoryRepository.save(CategoryMapper.fromDTO(productDTO.categoria())));

            // Mapear el DTO a una entidad
            ProductEntity productEntity = ProductMapper.fromDTO(productDTO);

            // Asignar relaciones
            productEntity.setMarca(marcaEntity);
            productEntity.setCategoria(categoryEntity);

            // Asignar fecha de creación
            productEntity.setCreated_at(LocalDateTime.now());

            // Guardar el producto
            ProductEntity savedEntity = productRepository.save(productEntity);

            // Mapear la entidad guardada a un DTO
            return ProductMapper.fromEntity(savedEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el producto: " + e.getMessage(), e);
        }
    }

    // LIST PRODUCTS
    public Iterable<ProductEntity> productList() {
        return productRepository.findAll();
    }


    
}