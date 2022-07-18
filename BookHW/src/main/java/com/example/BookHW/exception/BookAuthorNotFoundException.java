package com.example.BookHW.exception;

public class BookAuthorNotFoundException extends RuntimeException{
    public BookAuthorNotFoundException(String s){
        super(s);
    }
}
