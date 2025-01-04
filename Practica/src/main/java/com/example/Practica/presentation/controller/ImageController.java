package com.example.Practica.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Practica.services.ImageService;

@RestController
@RequestMapping("/upload/image")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {
    
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> createImage(@RequestParam("image") MultipartFile file) {
        try {
            String fileName = imageService.saveImage(file);
            String imageUrl = "http://localhost:8080/uploads/" + fileName; // Ruta completa
            return ResponseEntity.ok("Imagen subida exitosamente: " + imageUrl);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor: " + e.getMessage());
        }
    }
}
