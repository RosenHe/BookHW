package com.example.BookHW.repository;


import com.example.BookHW.model.Author;
import com.example.BookHW.model.Book;
import com.example.BookHW.model.Book_Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Book_AuthorRepository extends JpaRepository<Book_Author, Integer> {

    List<Book_Author> findByAuthor(Author author);
    List<Book_Author> findByBook(Book book);


}
