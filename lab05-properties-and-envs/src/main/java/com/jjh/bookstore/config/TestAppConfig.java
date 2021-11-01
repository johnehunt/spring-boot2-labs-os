package com.jjh.bookstore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("test")
@PropertySource("classpath:test-application.properties")
@ComponentScan(basePackages = {
        "com.jjh.bookstore.beans",
        "com.jjh.bookstore.dao",
        "com.jjh.bookstore.service"})
public class TestAppConfig {}
