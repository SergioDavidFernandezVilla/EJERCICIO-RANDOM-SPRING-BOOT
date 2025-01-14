package com.example.Practica.utils.userResponse.regex;

public class UserResponseRegex {

    // REGEX - Cambiar a static final
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{3,25}$";
    public static final String LASTNAME_REGEX = "^[a-zA-Z0-9_]{3,35}$";
    public static final String BIRTHDATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";


    // VALIDACIONES
    public static final String EMAIL_VALIDATION = "El email no es válido";
    public static final String PASSWORD_VALIDATION = "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial.";
    public static final String PASSWORD_CONFIRMATION_VALIDATION = "Las contraseñas no coinciden";
    public static final String USERNAME_VALIDATION = "El nombre de usuario debe contener entre 3 y 25 caracteres";
    public static final String LASTNAME_VALIDATION = "El apellido debe contener entre 3 y 35 caracteres";
    public static final String BIRTHDATE_VALIDATION = "La fecha de nacimiento no es válida";
}
