package com.dyer.frameworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Simple configuration <code>class</code> for a Spring Boot
 * Application.
 */
@ComponentScan
@EnableAutoConfiguration
public class ApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }

}
