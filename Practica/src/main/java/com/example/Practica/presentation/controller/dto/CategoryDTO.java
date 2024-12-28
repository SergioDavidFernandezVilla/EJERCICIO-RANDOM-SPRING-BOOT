package com.example.Practica.presentation.controller.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nombre", "descripcion" })
public record CategoryDTO(Long id, Set<String> nombre, String descripcion) {
    
}
