package com.example.Practica.utils.regex;

import com.example.Practica.utils.messageErrors.ValidationNotMessage;
import com.example.Practica.utils.messageErrors.category.CategoryValidationMessage;

public class ValidatorRegex {
    
    // VALIDORES REGEX
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NOMBRE_REGEX = "^[a-zA-ZÀ-ÿ\\s]{1,40}$";
    public static final String DESCRIPCION_REGEX = "^.{1,200}$";
    public static final String PRECIO_REGEX = "^[0-9]+(\\.[0-9]{1,2})?$";
    public static final String TELEFONO_REGEX = "^[0-9]{9}$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    // VALIDORES
    public static void validarNombre(String nombre) {
        if (!nombre.matches(NOMBRE_REGEX)) {
            throw new ValidationNotMessage("El nombre de la categoría no es válido");
        }
    }
    
    public static void validarDescripcion(String descripcion) {
        if (!descripcion.matches(DESCRIPCION_REGEX)) {
            throw new ValidationNotMessage("La descripción de la categoría no es válida");
        }
    }
}
