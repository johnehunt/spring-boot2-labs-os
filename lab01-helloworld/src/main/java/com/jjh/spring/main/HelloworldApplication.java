package com.jjh.spring.main;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		System.out.println("Starting the application");
//		SpringApplication.run(HelloworldApplication.class, args);
		SpringApplication app = new SpringApplication(HelloworldApplication.class);
		app.setBanner(new MyBanner());
		app.setLogStartupInfo(false); // stops default log info
		app.run(args);
		System.out.println("Application startup completed");
	}

}

class MyBanner implements Banner {
	public void printBanner(Environment environment,
							Class<?> sourceClass,
							PrintStream out) {
		out.println("---------------------");
		out.println("  My Custom Banner");
		out.println("---------------------");
	}
}
