package com.cook.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class CookServer {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(CookServer.class, args);
    }
}

