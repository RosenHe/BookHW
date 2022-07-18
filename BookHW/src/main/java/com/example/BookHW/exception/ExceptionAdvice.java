package com.example.BookHW.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({AuthorNotFoundException.class})
    public ResponseEntity<String> authorNotFound(AuthorNotFoundException e){
        System.out.println("Author Not Found exceptions found.");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<String> bookNotFound(BookNotFoundException e){
        System.out.println("Book Not Found exceptions found.");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
    @ExceptionHandler({BookAuthorNotFoundException.class})
    public ResponseEntity<String> bookAuthorNotFound(BookAuthorNotFoundException e){
        System.out.println("BookAuthorRelation Not Found exceptions found.");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
    @ExceptionHandler({NullParameterException.class})
    public ResponseEntity<String> NullParameter(NullParameterException e){
        System.out.println("Null Parameter exceptions found.");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> exception(Exception e){
        System.out.println("General exceptions found.");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
}
