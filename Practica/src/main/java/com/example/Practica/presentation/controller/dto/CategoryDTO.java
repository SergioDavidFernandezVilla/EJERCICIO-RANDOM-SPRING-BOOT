package com.example.Practica.presentation.controller.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nombre", "descripcion", "created_at", "updated_at" })
public record CategoryDTO(Long id, Set<String> nombre, String descripcion , String created_at, String updated_at) {
    
}
