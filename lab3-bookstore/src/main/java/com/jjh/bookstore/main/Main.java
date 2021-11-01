package com.jjh.bookstore.main;

import com.jjh.bookstore.domain.Book;
import com.jjh.bookstore.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jjh.bookstore.config")
public class Main {

    public static void main(String[] args) {
        System.out.print(("Main - Starting the application"));
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
        BookService service = ctx.getBean(BookService.class);
        System.out.println("---------------------------------------");
        System.out.println("BookStore.getName(): " + service.getName());
        System.out.println("BookStore.getMessage(): " + service.getMessage());
        System.out.println("BookStore.getDate(): " + service.getDate());
        System.out.println("---------------------------------------");
        for (Book book : service.getBooks()) {
            System.out.println("Book: " + book);
        }
        System.out.println("---------------------------------------");
    }
}
