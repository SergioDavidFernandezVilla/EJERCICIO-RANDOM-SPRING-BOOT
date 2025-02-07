package com.example.Practica.presentation.products.dto;

import java.time.LocalDateTime;

public record ProductDTO(
    Long id,
    String nombre,
    String descripcion,
    Double precio,
    LocalDateTime created_at,
    LocalDateTime updated_at,
    CategoryDTO categoria,  // Esto debe mapearse correctamente
    MarcaDTO marca,       // Esto también debe mapearse correctamente
    ImageDTO image
) {}
