package com.example.BookHW.controller;

import com.example.BookHW.model.Author;
import com.example.BookHW.model.Book_Author;
import com.example.BookHW.model.CommonResponse;
import com.example.BookHW.repository.Book_AuthorRepository;
import com.example.BookHW.service.AuthorService;
import com.example.BookHW.service.BookAuthorService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookAuthorService bookAuthorService;


    @PostMapping(path="/{name}")
    public ResponseEntity<CommonResponse> addAuthor(@PathVariable String name){
        return new ResponseEntity<>(authorService.addAuthor(name), HttpStatus.OK);
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<CommonResponse> getAuthor(@PathVariable int id){
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateAuthor(@PathVariable int id, @RequestBody String name){
        return new ResponseEntity<>(authorService.updateAuthor(id, name), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteAuthor(@PathVariable int id){
        return new ResponseEntity<>(authorService.deleteAuthor(id), HttpStatus.OK);
    }

    @GetMapping(path = "/authorBooks/{id}")
    public ResponseEntity<CommonResponse> getAuthorsFromBook(@PathVariable int id){
        return new ResponseEntity<>(bookAuthorService.getAllBooksFromAuthor(id), HttpStatus.OK);
    }

}
