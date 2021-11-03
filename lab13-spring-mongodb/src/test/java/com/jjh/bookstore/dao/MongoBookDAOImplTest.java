package com.jjh.bookstore.dao;

import com.jjh.bookstore.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = { TestConfig.class} )
class MongoBookDAOImplTest {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(@Qualifier("MongoBookDAO") BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Test
    void addAndDeleteBook() {
        Book book = new Book("654", "Kotlin and Spring", "Phoebe Byrne", "Tech Books", 14.99);
        this.bookDAO.addBook(book);
        int number = bookDAO.getBooks().size();
        Assertions.assertEquals(3, number, "There should be 3 book in the mongo bookstore");

        this.bookDAO.deleteBook(book);
        number = bookDAO.getBooks().size();
        Assertions.assertEquals(2, number, "There should be 2 book in the mongo bookstore");
    }

}