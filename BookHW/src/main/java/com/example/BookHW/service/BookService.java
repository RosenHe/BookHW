package com.example.BookHW.service;

import com.example.BookHW.model.CommonResponse;

public interface BookService {
    CommonResponse addBook(String name);
    CommonResponse getBook(int Id);
    CommonResponse updateBook(int Id, String name);
    CommonResponse deleteBook(int Id);
}
