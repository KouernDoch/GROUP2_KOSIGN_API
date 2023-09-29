package com.example.jpatesting.exception;

public class PaymentRequired extends RuntimeException{
    public PaymentRequired(String message){
      super(message);
    }
}
