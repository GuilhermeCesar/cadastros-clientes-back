package com.essencia.exception;

public class CustomerNotFoudException extends RuntimeException {

    public CustomerNotFoudException(String message){
        super(message);
    }

    public CustomerNotFoudException(String message, Throwable cause){
        super(message,cause);
    }
}
