package com.jjh.bookstore.beans;

import org.springframework.stereotype.Component;

@Component("MessageService")
public class MessageServiceImpl implements MessageService {

    private String message;

    public MessageServiceImpl() {
        this("Welcome");
    }

    public MessageServiceImpl(String msg) {
        System.out.println("MessageServiceImpl.<cons>(" + msg + ")");
        message = msg;
    }

    public String getMessage() {
        System.out.println("DefaultMessageService.getMessage()");
        return message;
    }

}
