package com.example.Practica.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.persistence.repository.ImageRepository;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${app.upload.dir:uploads}")
    private String uploadDir;

    public ImageService(ImageRepository imageRepository) throws IOException {
        this.imageRepository = imageRepository;
        // Crear el directorio de subida si no existe
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
    }

    public String saveImage(MultipartFile file) throws IOException {
        // Validar el archivo
        validateFile(file);

        // Generar un nombre único para el archivo
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();

        // Guardar el archivo en el sistema de archivos
        Files.copy(file.getInputStream(), filePath);

        // Guardar la información de la imagen en la base de datos
        ImageEntity image = new ImageEntity();
        image.setFileName(fileName);
        image.setFilePath(filePath.toString());
        image.setType(file.getContentType());
        imageRepository.save(image);

        // Retornar el nombre del archivo o una URL de acceso
        return fileName;
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
}
