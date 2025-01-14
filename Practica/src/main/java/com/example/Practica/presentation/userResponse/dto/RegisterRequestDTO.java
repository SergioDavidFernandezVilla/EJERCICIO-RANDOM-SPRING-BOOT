package com.example.Practica.presentation.userResponse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record RegisterRequestDTO(
    @Email String email,
    @NotBlank @Size(min = 8, max = 25) 
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
             message = "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial.")
    String password,
    @NotBlank String confirmPassword,
    @NotBlank @Size(min = 3, max = 25) String username,
    @Size(min = 3, max = 35) String lastName,
    @NotNull @Past LocalDate birthDate
) {}
