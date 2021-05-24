package com.reverie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminStart {

    public static void main(String[] args) {
        System.out.println("init...");
        SpringApplication.run(AdminStart.class);
        System.out.println("init finished...");
    }
}
