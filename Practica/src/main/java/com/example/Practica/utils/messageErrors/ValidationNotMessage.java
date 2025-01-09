package com.example.Practica.utils.messageErrors;

public class ValidationNotMessage extends RuntimeException {
    public ValidationNotMessage(String message){
        super(message);
    }
}
