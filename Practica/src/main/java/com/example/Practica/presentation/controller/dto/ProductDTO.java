package com.example.Practica.presentation.controller.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "nombre", "descripcion", "precio", "created_at", "updated_at" })
public record ProductDTO(
    Long id, 
    String nombre, 
    String descripcion, 
    double precio,
    LocalDateTime created_at, 
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updated_at // Si lo planeas usar
){
    public ProductDTO {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
}
