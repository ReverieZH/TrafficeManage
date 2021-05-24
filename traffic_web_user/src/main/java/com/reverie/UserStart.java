package com.reverie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserStart {

    public static void main(String[] args) {
        System.out.println("init...");
        SpringApplication.run(UserStart.class);
        System.out.println("init finished...");
    }
}
