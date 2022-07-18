package com.example.BookHW.service.impl;

import com.example.BookHW.exception.AuthorNotFoundException;
import com.example.BookHW.exception.BookAuthorNotFoundException;
import com.example.BookHW.exception.BookNotFoundException;
import com.example.BookHW.model.Author;
import com.example.BookHW.model.Book;
import com.example.BookHW.model.Book_Author;
import com.example.BookHW.model.CommonResponse;
import com.example.BookHW.repository.AuthorRepository;
import com.example.BookHW.repository.BookRepository;
import com.example.BookHW.repository.Book_AuthorRepository;
import com.example.BookHW.service.BookAuthorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class BookAuthorServiceImpl implements BookAuthorService {
    private final Logger log = LoggerFactory.getLogger(BookAuthorServiceImpl.class);
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final Book_AuthorRepository book_authorRepository;

    @Override
    public CommonResponse addBooksAuthorConnection(int a_id, int b_id) {
        CommonResponse response = new CommonResponse();
        Author author = authorRepository.findById(a_id).orElseThrow(()->
        {
            log.error("Can't find Author id: "+ a_id);
            log.debug("To fix: Re-enter Author id.");
            return new AuthorNotFoundException("Can't find id: " + a_id);
        });
        Book book = bookRepository.findById(b_id).orElseThrow(()->
        {
            log.error("Can't find Book id: "+ b_id);
            log.debug("To fix: Re-enter Book id.");
            return new BookNotFoundException("Can't find id: " + b_id);
        });
        Book_Author book_author = new Book_Author(book, author);
        book_authorRepository.save(book_author);
        response.setData(book_author);
        return response;
    }

    @Override
    public CommonResponse deleteBooksAuthorConnection(int id) {
        CommonResponse response = new CommonResponse();
        Book_Author book_author = book_authorRepository.findById(id).orElseThrow(()->{
            log.error("Can't find Book_Author id: "+ id);
            log.debug("To fix: Re-enter Book_Author id.");
            return new BookAuthorNotFoundException("Can't find id: " + id);
        });
        book_authorRepository.deleteById(id);
        response.setData("Delete successfully.");
        return response;
    }

    @Override
    public CommonResponse updateBooksAuthorConnection(int id, int a_id, int b_id) {
        CommonResponse response = new CommonResponse();
        Author author = authorRepository.findById(a_id).orElseThrow(()->
        {
            log.error("Can't find Author id: "+ a_id);
            log.debug("To fix: Re-enter Author id.");
            return new AuthorNotFoundException("Can't find id: " + a_id);
        });
        Book book = bookRepository.findById(b_id).orElseThrow(()->
        {
            log.error("Can't find Book id: "+ b_id);
            log.debug("To fix: Re-enter Book id.");
            return new BookNotFoundException("Can't find id: " + b_id);
        });
        Book_Author book_author = book_authorRepository.findById(id).orElseThrow(()->{
            log.error("Can't find Book_Author id: "+ id);
            log.debug("To fix: Re-enter Book_Author id.");
            return new BookAuthorNotFoundException("Can't find id: " + id);
        });
        book_author.setAuthor(author);
        book_author.setBook(book);
        book_authorRepository.save(book_author);
        response.setData(book_author);
        return response;
    }


    @Override
    public CommonResponse getAllBooksFromAuthor(int id) {
        CommonResponse response = new CommonResponse();
        Author author = authorRepository.findById(id).orElseThrow(()->
        {
            log.error("Can't find Author id: "+ id);
            log.debug("To fix: Re-enter Author id.");
            return new AuthorNotFoundException("Can't find id: " + id);
        });
        List<Book_Author> book_authorList = book_authorRepository.findByAuthor(author);
        if(book_authorList == null || book_authorList.isEmpty()){
            log.error("Can't find Books from Author with Id: "+ id);
            log.debug("To fix: Add Connection with Book and Author first.");
            throw new BookAuthorNotFoundException("Can't find Author's Books, Author id: " + id);
        }
        List<Book> bookList = book_authorList.stream().map(book_author -> {
            return book_author.getBook();
        }).collect(toList());
        response.setData(bookList);
        return response;
    }

    @Override
    public CommonResponse getAllAuthorFromBook(int id) {
        CommonResponse response = new CommonResponse();
        Book book = bookRepository.findById(id).orElseThrow(()-> {
            log.error("Can't find Book id: "+ id);
            log.debug("To fix: Re-enter Book id.");
            return new BookNotFoundException("Can't find book id: " + id);
        });
        List<Book_Author> book_authorList = book_authorRepository.findByBook(book);
        if(book_authorList == null || book_authorList.isEmpty()){
            log.error("Can't find author from Book with Id: "+ id);
            log.debug("To fix: Add Connection with Book and Author first.");
            throw new BookAuthorNotFoundException("Can't find book's Authors, Book id: " + id);
        }
        List<Author> authorList = book_authorList.stream().map(book_author -> book_author.getAuthor()).collect(toList());
        response.setData(authorList);
        return response;
    }
}
