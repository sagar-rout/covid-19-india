package com.rout.covid19india;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Covid19IndiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Covid19IndiaApplication.class, args);
    }

}
