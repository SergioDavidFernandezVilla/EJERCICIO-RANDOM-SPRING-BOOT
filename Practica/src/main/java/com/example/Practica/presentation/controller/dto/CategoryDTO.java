package com.example.Practica.presentation.controller.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({"id", "categoria", "descripcion", "created_at", "updated_at" })
public record CategoryDTO(

    Long id,

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 50, message = "La categoría no puede tener más de 50 caracteres")
    String categoria,
    
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 50, message = "La descripción no puede tener más de 50 caracteres")
    String descripcion
) {}
