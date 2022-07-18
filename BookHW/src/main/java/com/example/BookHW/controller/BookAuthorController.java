package com.example.BookHW.controller;

import com.example.BookHW.model.CommonResponse;
import com.example.BookHW.service.AuthorService;
import com.example.BookHW.service.BookAuthorService;
import com.example.BookHW.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bookAuthor")
public class BookAuthorController {
    @Autowired
    private BookAuthorService bookAuthorService;

    @PostMapping
    public ResponseEntity<CommonResponse> addBookAuthorConnection(@RequestParam("b_id") int b_id, @RequestParam("a_id") int a_id){
        return new ResponseEntity<>(bookAuthorService.addBooksAuthorConnection(b_id, a_id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateBookAuthorConnection(@PathVariable int id, @RequestParam("b_id") int b_id, @RequestParam("a_id") int a_id){
        return new ResponseEntity<>(bookAuthorService.updateBooksAuthorConnection(id, a_id, b_id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteBookAuthorConnection(@PathVariable int id){
        return new ResponseEntity<>(bookAuthorService.deleteBooksAuthorConnection(id), HttpStatus.OK);
    }


}
