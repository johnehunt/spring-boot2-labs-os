package com.jjh.bookstore.dao;

import com.jjh.bookstore.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { TestConfig.class} )
class BookDAOImplTest {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Test
    void getBooks() {
        int number = bookDAO.getBooks().size();
        Assertions.assertEquals(2, number, "There should be 2 books in the bookstore");
    }

    @Test
    void addBook() {
        Book book = new Book("654", "Kotlin and Spring", "Phoebe Byrne", "Tech Books", 14.99);
        this.bookDAO.addBook(book);
        int number = bookDAO.getBooks().size();
        Assertions.assertEquals(3, number, "There should be 3 books in the bookstore");
        bookDAO.getBooks().remove(book);
    }

    @Test
    void deleteBook() {
        Book book = bookDAO.getBooks().get(1);
        bookDAO.deleteBook(book);
        int number = bookDAO.getBooks().size();
        Assertions.assertEquals(1, number, "There should be 1 books in the bookstore");
        bookDAO.getBooks().add(book);
    }
}