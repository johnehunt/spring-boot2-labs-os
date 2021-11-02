package com.jjh.bookstore.controller;

import com.jjh.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
@RequestMapping("books")
public class BookstoreController {

    private BookService service;

    @Autowired
    public BookstoreController(BookService service) {
        this.service = service;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("BookstoreController.addViewControllers()");
        registry.addViewController("/error").setViewName("error");
    }

    // http://localhost:8080/books/list

    @RequestMapping("/list")
    public String getAllBooks(Model model) {
        System.out.println("BookstoreController.getAllBooks()");
        model.addAttribute("booklist", service.getBooks());
        // application code
        return "books";
    }

    // http://localhost:8080/books/hello

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("BookstoreController.hello()");
        return "<h2>" + service.getMessage()+ "</h2>";
    }

    // http://localhost:8080/books/name

    @RequestMapping("/name")
    @ResponseBody
    public String name() {
        System.out.println("BookstoreController.name()");
        return "<h2>" + service.getName()+ "</h2>";
    }


}
