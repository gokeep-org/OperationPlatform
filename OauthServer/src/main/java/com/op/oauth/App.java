package com.op.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
@ImportResource("classpath:application.xml")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}