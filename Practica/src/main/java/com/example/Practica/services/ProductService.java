package com.example.Practica.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.CategoryEntity;
import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.persistence.repository.CategoryRepository;
import com.example.Practica.persistence.repository.MarcaRepository;
import com.example.Practica.persistence.repository.ProductRepository;
import com.example.Practica.presentation.controller.dto.CategoryDTO;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import com.example.Practica.utils.mappers.CategoryMapper;
import com.example.Practica.utils.mappers.MarcaMapper;
import com.example.Practica.utils.mappers.ProductMapper;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO productCreate(ProductDTO productDTO) {
        try {
            // Crear o buscar la marca
           MarcaEntity marcaEntity = findOrCreateMarca(productDTO.marca());

            // Crear o buscar la categoría
            CategoryEntity categoryEntity = findOrCreateCategory(productDTO.categoria());

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

    private MarcaEntity findOrCreateMarca(MarcaDTO marcaDTO) {
        return marcaRepository.findById(marcaDTO.id())
            .orElseGet(() -> marcaRepository.save(MarcaMapper.fromDTO(marcaDTO)));
    }

    private CategoryEntity findOrCreateCategory(CategoryDTO categoryDTO) {
        return categoryRepository.findById(categoryDTO.id())
            .orElseGet(() -> categoryRepository.save(CategoryMapper.fromDTO(categoryDTO)));
    }

    // LIST PRODUCTS
    public List<ProductEntity> productList() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    // GET PRODUCT BY ID
    public ProductEntity productGetById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
}