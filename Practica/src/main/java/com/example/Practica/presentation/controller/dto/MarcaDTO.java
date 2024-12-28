package com.example.Practica.presentation.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "marca", "descripcion" })
public record MarcaDTO(Long id, String marca, String descripcion) {
    
}
