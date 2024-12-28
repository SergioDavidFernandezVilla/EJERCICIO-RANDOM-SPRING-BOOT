package com.example.Practica.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practica.presentation.controller.dto.ProductDTO;
import com.example.Practica.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/index")
    public String indexHome(){
        return "index";
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){
        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<ProductDTO> listProducts(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
