package com.example.Practica.presentation.controller.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "nombre", "descripcion", "precio", "created_at", "updated_at" })
public record ProductDTO(
    Long id, 
    String nombre, 
    String descripcion, 
    double precio,
    @JsonProperty("created_at") LocalDateTime createdAt, 
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at") LocalDateTime updatedAt // Si lo planeas usar
) {}
