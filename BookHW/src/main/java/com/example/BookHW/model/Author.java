package com.example.BookHW.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int authorId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId) && Objects.equals(name, author.name) && Objects.equals(Book_Author, author.Book_Author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, name, Book_Author);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", Book_Authors=" + Book_Author +
                '}';
    }
}
