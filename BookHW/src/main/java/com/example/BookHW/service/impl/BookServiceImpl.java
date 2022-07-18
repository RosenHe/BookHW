package com.example.BookHW.service.impl;

import com.example.BookHW.exception.BookNotFoundException;
import com.example.BookHW.exception.NullParameterException;
import com.example.BookHW.model.Book;
import com.example.BookHW.model.CommonResponse;
import com.example.BookHW.repository.BookRepository;
import com.example.BookHW.service.BookService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository bookRepository;

    @Override
    public CommonResponse addBook(String name) {
        CommonResponse response = new CommonResponse();
        if(name == null || name.length() == 0){
            log.error("String parameter {name} can't be null.");
            log.debug("To fix: Input Book name.");
            throw new NullParameterException("Book information can't be null.");
        }
        Book book = new Book();
        book.setName(name);
        bookRepository.save(book);
        response.setData(book.getBookId());
        return response;
    }

    @Override
    public CommonResponse getBook(int id) {
        CommonResponse response = new CommonResponse();
        Book book = bookRepository.findById(id).orElseThrow(()-> {
            log.error("Can't find Book id: "+ id);
            log.debug("To fix: Re-enter Book id.");
            return new BookNotFoundException("Can't find book id: " + id);
        });
        response.setData(book);
        return response;
    }

    @Override
    public CommonResponse updateBook(int id, String name) {
        CommonResponse response = new CommonResponse();
        Book book = bookRepository.findById(id).orElseThrow(()-> {
            log.error("Can't find Book id: "+ id);
            log.debug("To fix: Re-enter Book id.");
            return new BookNotFoundException("Can't find Book id: " + id);
        });
        book.setName(name);
        bookRepository.save(book);
        response.setData(book.getName());
        return response;
    }

    @Override
    public CommonResponse deleteBook(int id) {
        CommonResponse response = new CommonResponse();
        Book book = bookRepository.findById(id).orElseThrow(()-> {
            log.error("Can't find Book id: "+ id);
            log.debug("To fix: Re-enter Book id.");
            return new BookNotFoundException("Can't find Book id: " + id);
        });
        bookRepository.deleteById(id);
        response.setData("Delete Successfully.");
        return response;
    }
    
}
