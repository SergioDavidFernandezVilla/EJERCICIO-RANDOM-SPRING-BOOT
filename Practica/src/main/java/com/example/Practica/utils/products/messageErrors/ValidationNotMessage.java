package com.example.Practica.utils.products.messageErrors;

public class ValidationNotMessage extends RuntimeException {
    public ValidationNotMessage(String message){
        super(message);
    }
}
