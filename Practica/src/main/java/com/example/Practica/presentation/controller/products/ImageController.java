package com.example.Practica.presentation.controller.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.example.Practica.presentation.controller.dto.ImageDTO;
import com.example.Practica.services.products.ImageService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // GET ALL - Listar todas las imágenes
    @GetMapping("/all")
    public ResponseEntity<List<ImageDTO>> getAllImages() {
        return ResponseEntity.ok(imageService.findAllImages());
    }

    // Obtener una imagen por su nombre
    @GetMapping("/uploads/{fileName:.*}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        try {
            // Obtener la ruta completa de la imagen
            String filePath = imageService.getFileNameUrl(fileName);
            Path path = Paths.get(filePath);
            Resource resource = new UrlResource(path.toUri());

            // Validar que el archivo existe y es legible
            if (resource.exists() && resource.isReadable()) {
                // Detectar tipo MIME basado en la extensión del archivo
                String mimeType = java.nio.file.Files.probeContentType(path);
                MediaType mediaType = mimeType != null ? MediaType.parseMediaType(mimeType) : MediaType.APPLICATION_OCTET_STREAM;

                // Retornar la imagen con el tipo adecuado
                return ResponseEntity.ok()
                        .contentType(mediaType)
                        .body(resource);
            } else {
                // Si no existe o no es legible, retornar un error 404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Registrar el error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Crear y subir una nueva imagen
    @PostMapping("/upload")
    public ResponseEntity<String> createImage(@RequestParam("image") MultipartFile file) {
        try {
            // Llamar al servicio para guardar la imagen
            String fileName = imageService.saveImage(file);
            String imageUrl = "/images/uploads/" + fileName; // Ruta relativa de la imagen subida

            // Retornar la URL de la imagen guardada
            return ResponseEntity.ok("Imagen subida exitosamente: " + imageUrl);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(); // Registrar error interno
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor: " + e.getMessage());
        }
    }
}
