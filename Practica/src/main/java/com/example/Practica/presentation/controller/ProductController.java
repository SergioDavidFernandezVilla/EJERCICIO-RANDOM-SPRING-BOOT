package com.example.Practica.presentation.controller;


import java.util.List;

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
import com.example.Practica.utils.messageResponse.ApiResponse;

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

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> findAllProducts() {
        try {
            // Llamamos al servicio para obtener los productos
            List<ProductDTO> response = productService.findAllProducts();
            
            // Retornamos la respuesta exitosa con la lista de productos
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Productos obtenidos exitosamente")
                    .status("success")
                    .data(response)
                    .statusCode(200)
                    .error(null)
                    .build();

            return ResponseEntity.ok(apiResponse);

        } catch (Exception e) {
            // En caso de error, devolvemos una respuesta con el error
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Error al obtener los productos")
                    .status("error")
                    .data(null)
                    .statusCode(500)
                    .error(e.getMessage())
                    .build();

            return ResponseEntity.status(500).body(apiResponse);
        }
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