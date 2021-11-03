package com.jjh.bookstore.config;

import org.springframework.context.annotation.*;

@Configuration
@Profile("test")
@PropertySource("classpath:test-application.properties")
@ComponentScan(basePackages = {
        "com.jjh.bookstore.beans",
        "com.jjh.bookstore.dao",
        "com.jjh.bookstore.service",
        "com.jjh.bookstore.controller"})
@Import(JDBCDatabaseConfig.class)
public class TestAppConfig {}
