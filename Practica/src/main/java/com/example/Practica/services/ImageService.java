package com.example.Practica.services;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.persistence.entity.ProductEntity;
import com.example.Practica.persistence.repository.ImageRepository;
import com.example.Practica.persistence.repository.ProductRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Value("${app.upload-dir}")
    private String uploadDir;

    @Value("${app.base.url}")
    private String baseUrl;

    public String saveImage(MultipartFile file, Long productID) throws IOException {

        // CREAR LA CARPETA SI NO EXISTE
        if (!Files.exists(Paths.get(uploadDir))) {
            Files.createDirectories(Paths.get(uploadDir));
        }

        validateFile(file);

        String fileName = UUID.randomUUID().toString() + "_" + cleanFileName(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();

        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Validar y asociar el producto
        ProductEntity product = productRepository.findById(productID)
        .orElseThrow(() -> new IllegalArgumentException("El producto con ID " + productID + " no existe"));


            ImageEntity image = new ImageEntity();
            image.setFileName(fileName);
            image.setFilePath(filePath.toString());
            image.setType(file.getContentType());
            image.setProduct(product);
            imageRepository.save(image);

            // Dentro del método saveImage:
            return fileName;
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

}
