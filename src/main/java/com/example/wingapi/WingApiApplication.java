package com.example.wingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableJpaAuditing
@SpringBootApplication
@CrossOrigin
public class WingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WingApiApplication.class, args);
    }

}
