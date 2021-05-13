package com.cloud.config.server5566;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServer_5566 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_5566.class, args);
    }
}
