package com.example.BookHW.service;

import com.example.BookHW.model.CommonResponse;


public interface AuthorService {
    CommonResponse addAuthor(String name);
    CommonResponse getAuthor(int Id);
    CommonResponse updateAuthor(int Id, String name);
    CommonResponse deleteAuthor(int Id);
}
