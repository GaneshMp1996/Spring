package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.project")
public class NewspaperApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewspaperApplication.class, args);
    }
}