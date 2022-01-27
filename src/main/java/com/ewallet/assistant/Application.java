package com.ewallet.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@ConfigurationPropertiesScan("com.ewallet.assistant.config")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
