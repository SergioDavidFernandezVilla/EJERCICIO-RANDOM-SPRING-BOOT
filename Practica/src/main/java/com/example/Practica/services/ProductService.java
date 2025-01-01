package com.example.Practica.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.persistence.repository.ProductRepository;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import com.example.Practica.utils.mappers.ProductMapper;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET ALL WITH PAGINATION
    public Page<ProductDTO> findAllProducts(Pageable pageable) {
        Page<ProductEntity> products = productRepository.findAll(pageable);
        return products.map(ProductMapper.INSTANCE::fromEntity);
    }

    // GET BY ID
    public ProductDTO findByIdProduct(ProductDTO productDTO) {
        ProductEntity product = productRepository.findById(productDTO.id())
                .orElseThrow(
                        () -> new IllegalArgumentException("El producto con id " + productDTO.id() + " no existe"));
        return ProductMapper.INSTANCE.fromEntity(product);
    }

    // METODO CREATE
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {

        // Crear una instancia de ProductEntity a partir del DTO
        ProductEntity product = ProductMapper.INSTANCE.fromDTO(productDTO);
        ProductEntity productSaved = productRepository.save(product);
        return ProductMapper.INSTANCE.fromEntity(productSaved);
    }

    // METODO ACTULIZAR
    @Transactional
    public ProductDTO updateProduct(ProductDTO productDTO) {

        productRepository.findById(productDTO.id())
                .orElseThrow(
                        () -> new IllegalArgumentException("El producto con id " + productDTO.id() + " no existe"));

        ProductEntity updatedProduct = productRepository.save(ProductMapper.INSTANCE.fromDTO(productDTO));
        return ProductMapper.INSTANCE.fromEntity(updatedProduct);
    }

    // METODO DELETE
    public void deleteProduct(Long product_id) {
        if (!productRepository.existsById(product_id)) {
            throw new IllegalArgumentException("El producto con id " + product_id + " no existe");
        }
        productRepository.deleteById(product_id);
    }
}