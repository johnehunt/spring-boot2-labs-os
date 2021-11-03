package com.jjh.bookstore.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("MessageService")
public class MessageServiceImpl implements MessageService {

    private String message;

    public MessageServiceImpl() {
    }

    public MessageServiceImpl(String msg) {
        System.out.println("MessageServiceImpl.<cons>(" + msg + ")");
        message = msg;
    }

    public String getMessage() {
        System.out.println("DefaultMessageService.getMessage()");
        return message;
    }

    @Value("${bookstore.welcome.message}")
    public void setMessage(String message) {
        this.message = message;
    }

}
