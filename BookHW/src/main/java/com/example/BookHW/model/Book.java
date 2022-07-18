package com.example.BookHW.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int bookId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Book_Author> Book_Author = new ArrayList<>();

    public List<Book_Author> getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(List<Book_Author> book_Author) {
        Book_Author = book_Author;
    }
    public void addBook_Author(Book_Author ba){
        this.Book_Author.add(ba);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", Book_Author=" + Book_Author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(name, book.name) && Objects.equals(Book_Author, book.Book_Author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, name, Book_Author);
    }
}
