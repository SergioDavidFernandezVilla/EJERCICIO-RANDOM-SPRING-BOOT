package com.example.Practica.presentation.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "marca", "descripcion", "created_at", "updated_at" })
public record MarcaDTO(Long id, String marca, String descripcion, String created_at, String updated_at) {
    
}
