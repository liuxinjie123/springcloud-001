package com.cloud.provider.dept8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务启动后，自动注册到 Eureka中
 */
@EnableEurekaClient
@SpringBootApplication
public class Provider_8003 {
    public static void main(String[] args) {
        SpringApplication.run(Provider_8003.class, args);
    }
}
