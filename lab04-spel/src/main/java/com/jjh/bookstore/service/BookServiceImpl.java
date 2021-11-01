package com.jjh.bookstore.service;

import com.jjh.bookstore.beans.DateService;
import com.jjh.bookstore.beans.MessageService;
import com.jjh.bookstore.dao.BookDAO;
import com.jjh.bookstore.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    private MessageService messageService;
    private DateService dateService;
    private String name;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Autowired
    public void setMessageService(MessageService service) {
        System.out.println("WelcomeServiceImpl.setMessageService(" + service + ")");
        this.messageService = service;
    }

    @Autowired
    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }

    @Value("#{\"Johns book service\"}")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDate() {
        return this.dateService.getDate();
    }

    @Override
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public String getMessage() {
        return this.messageService.getMessage();
    }

    @Override
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Override
    public void deleteBook(Book book) {
        this.bookDAO.deleteBook(book);
    }

}
