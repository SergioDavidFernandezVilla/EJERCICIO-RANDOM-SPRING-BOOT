package com.example.Practica.utils.products.messageErrors.category;

public class CategoryNotFoundMessage extends RuntimeException {
    
    public CategoryNotFoundMessage(String message){
        super(message);
    }
}
