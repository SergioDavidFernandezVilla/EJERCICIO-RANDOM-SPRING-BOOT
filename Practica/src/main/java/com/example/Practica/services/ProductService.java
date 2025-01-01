package com.example.Practica.services;

import java.util.List;

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

    // GET ALL
    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(ProductMapper.INSTANCE::fromEntity)
                .toList();
    }

    // GET BY ID
    public ProductDTO findByIdProduct(ProductDTO productDTO) {
        if (!productRepository.existsById(productDTO.id())) {
            throw new IllegalArgumentException("El producto con id " + productDTO.id() + " no existe");
        }

        ProductEntity product = productRepository.findById(productDTO.id()).get();
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

        if (!productRepository.existsById(productDTO.id())) {
            throw new IllegalArgumentException("El producto con id " + productDTO.id() + " no existe");
        }

        ProductEntity product = productRepository.findById(productDTO.id()).get();
        product.setNombre(productDTO.nombre());
        product.setPrecio(productDTO.precio());
        product.setDescripcion(productDTO.descripcion());
        return ProductMapper.INSTANCE.fromEntity(product);
    }

    // METODO DELETE
    public void deleteProduct(Long product_id) {
        if (!productRepository.existsById(product_id)) {
            throw new IllegalArgumentException("El producto con id " + product_id + " no existe");
        }
        productRepository.deleteById(product_id);
    }
}