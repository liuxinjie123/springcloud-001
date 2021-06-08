package com.cloud.config.client3356;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient_3356 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3356.class, args);
    }
}
