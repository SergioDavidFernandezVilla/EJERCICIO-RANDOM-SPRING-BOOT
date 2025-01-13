package com.example.Practica.presentation.user.dto;

public record RegisterRequestDTO(
    String email, String password, 
    String confirmPassword, String name, 
    String lastName, String birthDate
) {
    
}
