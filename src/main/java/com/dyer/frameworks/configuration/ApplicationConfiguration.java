package com.dyer.frameworks.configuration;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Generic application configuration file.
 */
@Configuration
@PropertySource("application.properties")
public class ApplicationConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public Hashids hashids() {
        return new Hashids(environment.getProperty("giflib.hash.salt"), 8);
    }

}
