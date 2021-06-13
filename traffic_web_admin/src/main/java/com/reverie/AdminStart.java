package com.reverie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AdminStart {

    public static void main(String[] args) {
        System.out.println("init...");
        SpringApplication.run(AdminStart.class);
        System.out.println("init finished...");
    }
}
