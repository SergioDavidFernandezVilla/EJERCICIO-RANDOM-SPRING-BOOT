package com.example.Practica.presentation.userResponse.dto;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserRequestDTO(
    UUID id,
    String email,
    String password,
    String confirmPassword,
    String username,
    String lastName,
    LocalDate birthDate,
    LocalDateTime created_at,
    LocalDateTime updated_at
) {
    
}
