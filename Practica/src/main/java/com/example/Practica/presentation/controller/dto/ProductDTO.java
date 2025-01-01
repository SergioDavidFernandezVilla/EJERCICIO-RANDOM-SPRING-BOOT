package com.example.Practica.presentation.controller.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nombre", "descripcion", "precio", "marca", "categoria", "created_at", "updated_at" })
public record ProductDTO(
    Long id, 
    String nombre, 
    String descripcion, 
    double precio, 
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Opcional, si necesitas un formato específico
    @JsonProperty("created_at") LocalDateTime created_at, // CamelCase para consistencia
    MarcaDTO marca, 
    CategoryDTO categoria
) {}