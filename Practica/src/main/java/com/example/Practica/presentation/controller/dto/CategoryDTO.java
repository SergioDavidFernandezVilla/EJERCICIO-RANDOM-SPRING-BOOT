package com.example.Practica.presentation.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "categoria", "descripcion", "created_at", "updated_at" })
public record CategoryDTO(Long id, List<String> categoria, String descripcion , String created_at, String updated_at) {
    
}
