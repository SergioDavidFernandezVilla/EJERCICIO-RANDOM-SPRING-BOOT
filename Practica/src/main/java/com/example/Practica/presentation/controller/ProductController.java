package com.example.Practica.presentation.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Practica.presentation.controller.dto.ProductDTO;
import com.example.Practica.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/status")
    public String status() {
        return "Service is running";
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findByIdProduct(@Valid @RequestBody ProductDTO productDTO){
        ProductDTO responseDTO = productService.findByIdProduct(productDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
        ProductDTO responseDTO = productService.createProduct(productDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateByProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO){
        ProductDTO product = productService.updateProduct(productDTO);
        return ResponseEntity.ok(product);    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}