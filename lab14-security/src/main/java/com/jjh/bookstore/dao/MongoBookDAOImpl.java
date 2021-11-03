package com.jjh.bookstore.dao;

import com.jjh.bookstore.domain.Book;
import com.jjh.bookstore.mongo.BookMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("MongoBookDAO")
public class MongoBookDAOImpl implements BookDAO {

    private BookMongoRepository repo;

    @Autowired
    public void setRepo(BookMongoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> getBooks() {
        return repo.findAll();
    }

    @Override
    public void addBook(Book book) {
        repo.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        repo.deleteByIsbn(book.getIsbn());
    }
}
