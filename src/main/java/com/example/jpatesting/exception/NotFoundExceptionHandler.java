package com.example.jpatesting.exception;

public class NotFoundExceptionHandler extends RuntimeException{
    public NotFoundExceptionHandler(String message){
        super(message);
    }
}
