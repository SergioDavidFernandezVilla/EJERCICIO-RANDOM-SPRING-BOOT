package com.example.Practica.services;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.persistence.repository.ImageRepository;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${app.upload-dir}")
    private String uploadDir;

    @Value("${app.base.url}")
    private String baseUrl;

    public ImageService(ImageRepository imageRepository) throws IOException {
        this.imageRepository = imageRepository;
        // Crear el directorio de subida si no existe
        createUploadDir();
    }

    public String saveImage(MultipartFile file) throws IOException {
        validateFile(file);

        String fileName = UUID.randomUUID().toString() + "_" + cleanFileName(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();

        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            ImageEntity image = new ImageEntity();
            image.setFileName(fileName);
            image.setFilePath(filePath.toString());
            image.setType(file.getContentType());
            imageRepository.save(image);

            // Dentro del método saveImage:
            return baseUrl + "/images/" + fileName;
        } catch (IOException e) {
            // Manejo de errores al guardar el archivo
            throw new IOException("Error al guardar la imagen en el sistema de archivos", e);
        }
    }

    private void createUploadDir() throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede estar vacío");
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("El archivo debe ser una imagen");
        }
    }

    private String cleanFileName(String fileName) {
        return fileName.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
    }
}
