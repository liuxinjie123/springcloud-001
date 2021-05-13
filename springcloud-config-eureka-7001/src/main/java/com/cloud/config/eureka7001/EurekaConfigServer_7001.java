package com.cloud.config.eureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaConfigServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigServer_7001.class, args);
    }
}
