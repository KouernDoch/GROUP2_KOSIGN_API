package com.example.jpatesting.exception;

public class LockedException extends RuntimeException{
    public LockedException(String message){
        super(message);
    }
}
