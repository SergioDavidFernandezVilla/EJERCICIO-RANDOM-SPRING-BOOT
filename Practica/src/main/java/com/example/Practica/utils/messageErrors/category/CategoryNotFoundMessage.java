package com.example.Practica.utils.messageErrors.category;

public class CategoryNotFoundMessage extends RuntimeException {
    
    public CategoryNotFoundMessage(String message){
        super(message);
    }
}
