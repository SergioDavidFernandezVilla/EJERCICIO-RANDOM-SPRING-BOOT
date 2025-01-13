package com.example.Practica.presentation.user.dto;

public record LoginRequestDTO(
    String email, String password, 
    String confirmPassword ){
    
}
