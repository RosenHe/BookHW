package com.example.BookHW.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book_author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book_Author implements Serializable {
    public Book_Author(Book book, Author author){
        this.book = book;
        this.author = author;
    }
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "b_id", referencedColumnName = "bookId")
    private Book book;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_id", referencedColumnName = "authorId")
    private Author author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book_Author that = (Book_Author) o;
        return Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, author);
    }

    @Override
    public String toString() {
        return "Book_Author{" +
                "id=" + id +
                ", book=" + book +
                ", author=" + author +
                '}';
    }
}
