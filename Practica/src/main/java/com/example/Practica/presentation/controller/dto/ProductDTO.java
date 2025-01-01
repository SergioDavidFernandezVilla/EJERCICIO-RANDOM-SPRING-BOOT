package com.example.Practica.presentation.controller.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({ "id", "nombre", "descripcion", "precio", "created_at", "updated_at" })
public record ProductDTO(
    Long id,

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre de un producto no puede tener más de 100 caracteres")
    String nombre, 

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción de un producto no puede tener más de 255 caracteres")
    String descripcion,
    
    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    Double precio,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime created_at, 

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updated_at 
) {
    // Constructor compacto opcional si necesitas validaciones personalizadas.
    public ProductDTO {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
}
