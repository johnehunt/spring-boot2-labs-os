package com.jjh.bookstore.service;

import com.jjh.bookstore.domain.Book;

import java.util.List;

public interface BookService {
    String getName();

    String getDate();

    List<Book> getBooks();

    String getMessage();

    void addBook(Book book);

    void deleteBook(Book book);

    Book getBookByTitle(String title);
    void updateBook(Book newVersionOfBook);
    void deleteBook(String title);

}
