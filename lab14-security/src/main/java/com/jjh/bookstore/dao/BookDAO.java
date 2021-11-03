package com.jjh.bookstore.dao;

import com.jjh.bookstore.domain.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();

    void addBook(Book book);

    void deleteBook(Book book);
}
