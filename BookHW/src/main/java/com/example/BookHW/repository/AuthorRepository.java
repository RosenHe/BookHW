package com.example.BookHW.repository;

import com.example.BookHW.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
