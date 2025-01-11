package com.example.Practica.presentation.products.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "nombre", "descripcion", "created_at", "updated_at" })
public record MarcaDTO(Long id, String nombre, String descripcion, LocalDateTime created_at, LocalDateTime updated_at) {
    
}
