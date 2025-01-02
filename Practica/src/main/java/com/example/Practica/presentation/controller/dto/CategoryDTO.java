package com.example.Practica.presentation.controller.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "categoria", "descripcion", "created_at", "updated_at" })
public record CategoryDTO(Long id, String categoria, String descripcion, String created_at, String updated_at) {
    
}