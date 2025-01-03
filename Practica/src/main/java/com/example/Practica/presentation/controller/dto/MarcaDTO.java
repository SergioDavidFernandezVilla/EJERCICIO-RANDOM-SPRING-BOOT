package com.example.Practica.presentation.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "marca", "descripcion", "created_at", "updated_at" })
public record MarcaDTO(Long id, String marca, String descripcion, LocalDateTime created_at, LocalDateTime updated_at) {
    
}
