package com.example.jpatesting.exception;

public class InternalServerExeptionHandler extends RuntimeException{
    public InternalServerExeptionHandler(String message){
        super(message);
    }
}
