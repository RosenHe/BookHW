package com.example.BookHW.controller;

import com.example.BookHW.model.CommonResponse;
import com.example.BookHW.service.BookAuthorService;
import com.example.BookHW.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;

    @PostMapping(path="/{name}")
    public ResponseEntity<CommonResponse> addAuthor(@PathVariable String name){
        return new ResponseEntity<>(bookService.addBook(name), HttpStatus.OK);
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<CommonResponse> getAuthor(@PathVariable int id){
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CommonResponse> updateAuthor(@PathVariable int id, @RequestBody String name){
        return new ResponseEntity<>(bookService.updateBook(id, name), HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CommonResponse> deleteAuthor(@PathVariable int id){
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }

    @GetMapping(path = "/booksAuthor/{id}")
    public ResponseEntity<CommonResponse> getAuthorsFromBook(@PathVariable int id){
        return new ResponseEntity<>(bookAuthorService.getAllAuthorFromBook(id), HttpStatus.OK);
    }

}
