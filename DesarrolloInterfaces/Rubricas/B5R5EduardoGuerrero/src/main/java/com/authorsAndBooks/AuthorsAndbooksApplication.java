package com.authorsAndBooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.authorsAndBooks.*")
public class AuthorsAndbooksApplication {
	public static void main(String[] args) {
        SpringApplication.run(AuthorsAndbooksApplication.class, args);
    }
}
