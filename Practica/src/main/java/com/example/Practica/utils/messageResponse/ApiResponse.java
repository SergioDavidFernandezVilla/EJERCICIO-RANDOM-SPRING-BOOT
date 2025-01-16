package com.example.Practica.utils.messageResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    
    private String message;
    private String status; 
    private Object data;
    private int statusCode;
    private String error;
    private Pagination pagination; // Información de paginación
    
    // Clase interna para manejar la paginación
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pagination {
        private int currentPage;
        private int totalPages;
        private int pageSize;
        private long totalElements;
    }
}