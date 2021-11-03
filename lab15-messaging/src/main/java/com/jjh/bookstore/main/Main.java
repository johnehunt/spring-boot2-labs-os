package com.jjh.bookstore.main;

import com.jjh.bookstore.domain.Book;
import com.jjh.bookstore.jms.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jjh.bookstore.config")
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting");
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        Sender sender = context.getBean(Sender.class);

        // Publish a book
        System.out.println("Sending an book message.");
        Book book = new Book("123", "Java and Spring", "John Smith", "Tech Books", 12.99);
        sender.send(book);

        System.out.println("Press Enter to Terminate");
        System.in.read();
        context.close();
    }
}
