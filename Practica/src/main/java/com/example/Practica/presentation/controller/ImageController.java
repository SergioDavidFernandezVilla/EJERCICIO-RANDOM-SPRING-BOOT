package com.example.Practica.presentation.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Practica.services.ImageService;

import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/upload/image")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // Obtener la imagen
    @GetMapping("/{filename}")
public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
    try {
        // Obtener la ruta absoluta del archivo
        String filePath = imageService.getFileNameUrl(fileName);
        Path path = Paths.get(filePath);
        Resource resource = new UrlResource(path.toUri());

        System.out.println("URI del recurso: " + path.toUri());
        System.out.println("Ruta del recurso: " + path.toString());

        // Validar que el archivo existe y es legible
        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Ajusta al tipo MIME adecuado
                    .body(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    } catch (Exception e) {
        e.printStackTrace(); // Registrar el error
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null);
    }
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
