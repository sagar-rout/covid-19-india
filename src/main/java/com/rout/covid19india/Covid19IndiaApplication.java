package com.rout.covid19india;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Covid19IndiaApplication {

    private static final Logger logger = LoggerFactory.getLogger(Covid19IndiaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Covid19IndiaApplication.class, args);
    }
}
