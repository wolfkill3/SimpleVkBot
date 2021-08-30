package com.example.justai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JustAiApplication {
    public static void main(String[] args) {
        SpringApplication.run(JustAiApplication.class, args);
        ApiConfig.getInstance();
    }
}
