/*
 * @(#)HrmsApplication.java
 */
package com.example.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Start a Spring boot application.
 * 
 * @author Su Su Paing
 *
 */
@SpringBootApplication
@EnableScheduling
public class HrmsApplication {

    /**
     * Main method of the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
    }
}