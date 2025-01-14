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
    public ResponseEntity<ApiResponse> getAllUsers(@PageableDefault(size = 10) Pageable pageable) {

        try {

            Page<UserRequestDTO> response = userService.findAllUsers(pageable);

            ApiResponse.Pagination pagination = new ApiResponse.Pagination(
                    response.getNumber(),
                    response.getTotalPages(),
                    response.getSize(),
                    response.getTotalElements());

            // Retornar la respuesta exitosa con los productos y la paginación
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Usuarios obtenidos exitosamente")
                    .statusCode(200)
                    .status("success")
                    .data(response.getContent()) // Los productos de la página
                    .pagination(pagination) // Incluir la paginación
                    .error(null)
                    .build();

            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            // Si hay un error, devolver una respuesta de error
            ApiResponse apiResponse = ApiResponse.builder()
                    .message("Error al obtener los productos")
                    .status("error")
                    .data(null)
                    .statusCode(500)
                    .error(e.getMessage())
                    .build();

            return ResponseEntity.status(500).body(apiResponse);
        }
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
