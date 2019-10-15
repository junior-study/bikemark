package com.jrstudy.bikemark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BikemarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikemarkApplication.class, args);
    }

}
