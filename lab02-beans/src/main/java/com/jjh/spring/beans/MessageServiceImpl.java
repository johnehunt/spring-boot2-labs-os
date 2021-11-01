package com.jjh.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("MessageService")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MessageServiceImpl implements MessageService {

    private String message;
    private ApplicationContext context;

    public MessageServiceImpl() {
        this("Welcome");
    }

    public MessageServiceImpl(String msg) {
        System.out.println("MessageServiceImpl.<cons>(" + msg + ")");
        message = msg;
    }

    public String getMessage() {
        System.out.println("MessageServiceImpl.getMessage()");
        return message;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        System.out.println("MessageServiceImpl.setContext() - Registering the application context");
        this.context = context;
    }

    // Lifecycle methods

    @PostConstruct
    public void setupMessageService() {
        System.out.println("MessageServiceImpl.setupMessageService()");
    }
    @PreDestroy
    public void shutdownMessageService() {
        System.out.println("MessageServiceImpl.shutdownMessageService()");
    }

}
