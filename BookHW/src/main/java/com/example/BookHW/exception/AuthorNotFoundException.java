package com.example.BookHW.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String s){
        super(s);
    }
}
