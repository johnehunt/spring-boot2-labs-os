package com.jjh.bookstore.service;

import com.jjh.bookstore.beans.DateService;
import com.jjh.bookstore.beans.MessageService;
import com.jjh.bookstore.dao.BookDAO;
import com.jjh.bookstore.domain.Book;
import com.jjh.bookstore.domain.BookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    private MessageService messageService;
    private DateService dateService;
    private String name;

    @Autowired
    public BookServiceImpl(@Qualifier("JDBCBookDAO") BookDAO bookDAO) {
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

    @Value("${bookstore.name}")
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

    // New methods

    public Book getBookByTitle(String title) {
        System.out.println("Bookshop.getBook(" + title + ")");
        List<Book> books = bookDAO.getBooks().stream().filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if (books.size() > 0)
            return books.get(0);
        else
            return null;
    }

    public void updateBook(Book newVersionOfBook) {
        System.out.println("Bookshop.updateBook(" + newVersionOfBook + ")");
        Book originalBook = this.getBookByTitle(newVersionOfBook.getTitle());
        if (originalBook == null)
            throw new BookException("Book with title: " + newVersionOfBook.getTitle() + " not found");
        originalBook.setAuthor(newVersionOfBook.getAuthor());
        originalBook.setPrice(newVersionOfBook.getPrice());
    }

    public void deleteBook(String title) {
        System.out.println("Bookshop.deleteBook(" + title + ")");
        Book book = this.getBookByTitle(title);
        if (book != null)
            this.bookDAO.deleteBook(book);
        else
            throw new BookException("Book with title: " + title + " not found");
    }

}
