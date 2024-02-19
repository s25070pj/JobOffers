package com.example.joboffers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestJobOffersApplication {

    public static void main(String[] args) {
        SpringApplication.from(JobOffersApplication::main).with(TestJobOffersApplication.class).run(args);
    }

}
