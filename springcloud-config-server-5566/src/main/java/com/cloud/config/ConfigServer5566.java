package com.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer5566 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer5566.class, args);
    }
}
