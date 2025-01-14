package com.example.Practica.presentation.userResponse.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practica.presentation.userResponse.dto.LoginRequestDTO;
import com.example.Practica.presentation.userResponse.dto.RegisterRequestDTO;
import com.example.Practica.services.user.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/status")
    public String getStatus() {
        return "OK";
    }

    // Otros métodos para manejar las operaciones relacionadas con los usuarios
    @PostMapping("/register")
    public ResponseEntity<RegisterRequestDTO> createUser(RegisterRequestDTO registerRequestDTO){
        return ResponseEntity.status(201).body(userService.registerUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginUser(LoginRequestDTO loginRequestDTO){
        return ResponseEntity.status(200).body(userService.loginUser(loginRequestDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }
}
