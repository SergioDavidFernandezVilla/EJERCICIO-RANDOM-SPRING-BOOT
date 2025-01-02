package com.example.Practica.presentation.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ApiResponse> findAllProducts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            // Crear el objeto Pageable con la página y el tamaño
            Pageable pageable = PageRequest.of(page, size);

            // Llamar al servicio para obtener los productos con sus relaciones
            Page<ProductDTO> response = productService.findAllProducts(pageable);

            // Construir la respuesta con los datos de paginación
            ApiResponse.Pagination pagination = new ApiResponse.Pagination(
                    response.getNumber(),
                    response.getTotalPages(),
                    response.getSize(),
                    response.getTotalElements());

            // Retornar la respuesta exitosa con los productos y la paginación
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Productos obtenidos exitosamente")
                    .statusCode(200)
                    .status("success")
                    .data(response.getContent()) // Los productos de la página
                    .pagination(pagination) // Incluir la paginación
                    .error(null)
                    .build();

            return ResponseEntity.ok(apiResponse);

        } catch (Exception e) {
            // Si hay un error, devolver una respuesta de error
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
    public ResponseEntity<ProductDTO> findByIdProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO responseDTO = productService.findByIdProduct(productDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO responseDTO = productService.createProduct(productDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateByProduct(@PathVariable Long id,
            @Valid @RequestBody ProductDTO productDTO) {
        ProductDTO product = productService.updateProduct(productDTO);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}