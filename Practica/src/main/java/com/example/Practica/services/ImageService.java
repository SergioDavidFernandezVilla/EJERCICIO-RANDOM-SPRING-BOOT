package com.example.Practica.services;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.persistence.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${app.upload-dir}")
    private String uploadDir;

    @Value("${app.base.url}")
    private String baseUrl;

    public String saveImage(MultipartFile file) throws IOException {
        createUploadDir(); // Centralizamos la creación del directorio
        validateFile(file);
    
        String fileName = UUID.randomUUID().toString() + "_" + cleanFileName(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
    
        if (Files.exists(filePath)) {
            throw new IOException("Un archivo con este nombre ya existe: " + fileName);
        }
    
        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    
            ImageEntity image = new ImageEntity();
            image.setFileName(fileName);
            image.setFilePath(fileName); // Solo guardamos la ruta relativa
            image.setType(file.getContentType());
            imageRepository.save(image);
    
            return fileName;
        } catch (IOException e) {
            throw new IOException("Error al guardar la imagen", e);
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

    public String getImageUrl(String fileName) {
        return "/uploads/" + fileName; // Devuelve la URL relativa
    }

    public String getFileNameUrl(String fileName) {
        ImageEntity image = imageRepository.findByFileName(fileName);
        if (image != null) {
            return image.getFilePath();
        }
        return null;
    }

    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }
}
