package com.example.s21library_rockethandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class S21LibraryRocketHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(S21LibraryRocketHandlerApplication.class, args);
    }

}
