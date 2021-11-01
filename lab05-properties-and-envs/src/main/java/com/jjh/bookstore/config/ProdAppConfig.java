package com.jjh.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@Profile("prod")
@PropertySource("classpath:prod-application.properties")
@ComponentScan(basePackages = {
        "com.jjh.bookstore.beans",
        "com.jjh.bookstore.dao",
        "com.jjh.bookstore.service"})
public class ProdAppConfig {}
