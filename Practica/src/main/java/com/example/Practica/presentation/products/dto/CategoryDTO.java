package com.example.Practica.presentation.products.dto;

import java.time.LocalDateTime;

public record CategoryDTO(Long id, String nombre, String descripcion, LocalDateTime created_at, LocalDateTime updated_at) {
    
}