package com.bgi.docking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DockingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockingApplication.class, args);
    }

}
