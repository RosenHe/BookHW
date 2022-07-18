package com.example.BookHW.service;


import com.example.BookHW.model.CommonResponse;

public interface BookAuthorService {
    CommonResponse addBooksAuthorConnection(int a_id, int b_id);
    CommonResponse deleteBooksAuthorConnection(int id);
    CommonResponse updateBooksAuthorConnection(int id, int a_id, int b_id);
    CommonResponse getAllBooksFromAuthor(int id);
    CommonResponse getAllAuthorFromBook(int id);

}
