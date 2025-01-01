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
    
    private String message;     // Mensaje descriptivo de la respuesta
    private String status;      // Estado de la respuesta (por ejemplo, "success" o "error")
    private Object data;        // Datos devueltos (por ejemplo, lista de productos)
    private int statusCode;     // Código de estado HTTP (por ejemplo, 200, 404, etc.)
    private String error;       // Información sobre el error (si hay un error)

    // Constructor adicional para facilitar respuestas sin error
    public ApiResponse(String message, String status, Object data, int statusCode) {
        this.message = message;
        this.status = status;
        this.data = data;
        this.statusCode = statusCode;
        this.error = null; // Si no hay error, lo dejamos en null
    }
}
