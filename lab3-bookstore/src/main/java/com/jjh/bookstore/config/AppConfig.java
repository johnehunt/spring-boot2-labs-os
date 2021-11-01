package com.jjh.bookstore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.jjh.bookstore.beans",
        "com.jjh.bookstore.dao",
        "com.jjh.bookstore.service"})
public class AppConfig {}
