package com.example.Practica.presentation.controller.dto;

import java.time.LocalDateTime;

public record CategoryDTO(Long id, String categoria, String descripcion, LocalDateTime created_at, LocalDateTime updated_at) {
    
}