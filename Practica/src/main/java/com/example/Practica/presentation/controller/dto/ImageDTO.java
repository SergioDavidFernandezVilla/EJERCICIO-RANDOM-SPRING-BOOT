package com.example.Practica.presentation.controller.dto;

import java.time.LocalDateTime;

public record ImageDTO(Long id, String type, String fileName, String filePath, LocalDateTime uploadedA) {
    
}
