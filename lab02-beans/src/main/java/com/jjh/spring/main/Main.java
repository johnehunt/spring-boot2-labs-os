package com.jjh.spring.main;

import com.jjh.spring.beans.DateService;
import com.jjh.spring.beans.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.spring.beans")
public class Main {
    public static void main(String[] args) {
        System.out.print(("Main - Starting the application"));
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);

        System.out.println("Main - requesting MessageService");
        MessageService service = ctx.getBean(MessageService.class);
        System.out.println(service.getMessage());

        System.out.println("Main - requesting 2nd MessageService");
        MessageService service2 = ctx.getBean(MessageService.class);
        System.out.println(service2.getMessage());

        System.out.println("Main - requesting DateService");
        DateService ds1 = ctx.getBean(DateService.class);
        System.out.println(ds1.getDate());

        ctx.close();

        System.out.print(("Main - Application startup completed"));
    }
}
