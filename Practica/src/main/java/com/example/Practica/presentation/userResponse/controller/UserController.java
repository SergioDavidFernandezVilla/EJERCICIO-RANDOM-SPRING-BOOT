package com.example.Practica.presentation.userResponse.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practica.presentation.userResponse.dto.LoginRequestDTO;
import com.example.Practica.presentation.userResponse.dto.RegisterRequestDTO;
import com.example.Practica.presentation.userResponse.dto.UserRequestDTO;
import com.example.Practica.services.user.UserService;
import com.example.Practica.utils.products.messageResponse.ApiResponse;

import jakarta.validation.Valid;

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

    @GetMapping("/all")
    public ResponseEntity<Page<UserRequestDTO>> getAllUsers(@PageableDefault(size = 10) Pageable pageable) {
        Page<UserRequestDTO> users = userService.findAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    // Otros métodos para manejar las operaciones relacionadas con los usuarios
    @PostMapping("/register")
    public ResponseEntity<RegisterRequestDTO> createUser(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(201).body(userService.registerUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.status(200).body(userService.loginUser(loginRequestDTO));
    }

}
