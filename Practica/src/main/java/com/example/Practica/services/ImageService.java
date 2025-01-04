package com.example.Practica.services;

import java.io.IOException;
import java.nio.file.*;
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

        // CREAR LA CARPETA SI NO EXISTE
        if (!Files.exists(Paths.get(uploadDir))) {
            Files.createDirectories(Paths.get(uploadDir));
        }

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

    public String getFileNameUrl(String filename) throws IOException {
        try {
            // Verificamos si el nombre del archivo es nulo o vacío
            if (filename == null || filename.trim().isEmpty()) {
                return null; // Si el nombre es inválido, retornamos null
            }
    
            // Creamos la ruta completa del archivo en el directorio de carga
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
    
            // Verificamos si el archivo existe en el sistema de archivos
            if (Files.exists(filePath)) {
                // Si el archivo existe, retornamos la URL relativa
                return baseUrl + "/uploads/" + filename;  // baseUrl se define en las propiedades del archivo de configuración
            }
    
            return null;  // Si el archivo no existe, retornamos null
        } catch (Exception e) {
            // Manejo de errores al obtener el archivo
            throw new IOException("Error al buscar el archivo en el sistema de archivos", e);
        }
    }
}
