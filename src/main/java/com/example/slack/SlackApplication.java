package com.example.slack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SlackApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SlackApplication.class, args);
        SpringApplication.exit(run);
    }

}
