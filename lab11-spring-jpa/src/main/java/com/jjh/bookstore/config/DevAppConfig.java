package com.jjh.bookstore.config;

import org.springframework.context.annotation.*;

@Configuration
@Profile("dev")
@PropertySource("classpath:dev-application.properties")
@ComponentScan(basePackages = {
        "com.jjh.bookstore.beans",
        "com.jjh.bookstore.dao",
        "com.jjh.bookstore.service",
        "com.jjh.bookstore.controller"})
@Import(JDBCDatabaseConfig.class)
public class DevAppConfig {}
