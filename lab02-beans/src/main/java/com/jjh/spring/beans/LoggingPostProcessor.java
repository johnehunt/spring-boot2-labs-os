package com.jjh.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggingPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        System.out.println("LoggingPostProcessor - postProcessBeforeInitialization: " + name);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        System.out.println("LoggingPostProcessor - postProcessAfterInitialization: " + name);
        return bean;
    }
}