package com.example.justai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JustAiApplication {
    public static void main(String[] args) {
        ApiConfig config = ApiConfig.getInstance();
        System.getProperties().put("server.port", config.getServerPort());
        SpringApplication.run(JustAiApplication.class, args);
    }
}
