package com.cloud.consumer.dept.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Ribbon 和 Eureka 整合以后，客户端可以直接调用方法，不用关心ip和端口
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.cloud.consumer.dept.feign"})
public class ConsumerFeign_80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign_80.class, args);
    }
}
